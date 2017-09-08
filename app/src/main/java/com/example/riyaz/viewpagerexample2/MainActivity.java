package com.example.riyaz.viewpagerexample2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.jar.Manifest;

import static com.example.riyaz.viewpagerexample2.R.attr.layoutManager;

//Implementing the interface OnTabSelectedListener to our MainActivity
//This interface would help in swiping views
public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    MenuItem shuffle;
    private ShareActionProvider sharedAction;
    //This is our tablayout
    private TabLayout tabLayout;
    final int RC = 17;
    private List<Data> data = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    View mv;
    String[] country = {"india", "usa", "pakistan", "china", "egypt", "canada", "malysia", "uae", "uk",
            "france", "poland", "greece", "mexico", "spain", "australia"};
    String[] capital = {"Delhi", "Washington", "Islamabad", "Bejing", "Cairo", "Toronto", "Mala", "Abu dhabi",
            "London", "Paris", "poland", "Athens", "Mexico City", "Barcelona", "Sydney"};
    int[] pics = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,
            R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12,R.drawable.img13,R.drawable.img14,R.drawable.img15,
    };
    //This is our viewPager
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Welcome to My world");
        setSupportActionBar(toolbar);

        mv = findViewById(R.id.main_layout);

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Tab1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);


        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater mi = getMenuInflater();
//        mi.inflate(R.menu.menu_main,menu);
//        shuffle =(MenuItem)findViewById(R.id.shuffle);
//        sharedAction = (ShareActionProvider) MenuItemCompat.getActionProvider(shuffle);
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        askPermission(android.Manifest.permission.CAMERA, RC);
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void askPermission(final String permission, final int requestCode) {
//        if(ContextCompat.checkSelfPermission(this,permission)!= PackageManager.PERMISSION_GRANTED){
//
//            //ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
//            if(!ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CAMERA)){
//                Toast.makeText(this, "Please go to Setting & Change Permissions", Toast.LENGTH_LONG).show();
//            }
//            else if(ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CAMERA)){
//                Snackbar.make(mv, "Please Give Permission...", Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);
//                    }
//                }).show();
//            }
//        }else{
//            data.add(new Data(R.drawable.img1, "india"));
//            data.add(new Data(R.drawable.img2, "usa"));
//            data.add(new Data(R.drawable.img3, "pakistan"));
//            data.add(new Data(R.drawable.img4, "china"));
//            data.add(new Data(R.drawable.img5, "egypt"));
//            data.add(new Data(R.drawable.img6, "canada"));
//            data.add(new Data(R.drawable.img7, "malaysia"));
//            data.add(new Data(R.drawable.img8, "uae"));
//            data.add(new Data(R.drawable.img9, "uk"));
//            data.add(new Data(R.drawable.img10, "france"));
//            data.add(new Data(R.drawable.img11, "poland"));
//            data.add(new Data(R.drawable.img12, "greece"));
//            data.add(new Data(R.drawable.img13, "mexico"));
//            data.add(new Data(R.drawable.img14, "spain"));
//            data.add(new Data(R.drawable.img15, "australia"));
//
////            int[] rimage = new int[15];
//            String[] country_temp = new String[15];
//            String[] capital_temp = new String[15];
//            int[] pics_temp = new int[15];
//            Random r = new Random();
//
//            for(int i = 0; i<15; i++) {
//                int n = r.nextInt(15);
//                pics_temp[i] = pics[n];
//                country_temp[i] = country[n];
//                capital_temp[i] = capital[n];
//
//            }
//            data.clear();
//            for(int i= 0; i<15; i++ ){
//                data.add(new Data(pics_temp[i], country_temp[i]));
//            }
//
//
//            recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
//            adapter = new RecyclerAdapter(country_temp, capital_temp,data);
//            recyclerView.setAdapter(adapter);
//            layoutManager = new LinearLayoutManager(this);
//            recyclerView.setLayoutManager(layoutManager);
//            Toast.makeText(this, "Permission has already granted", Toast.LENGTH_LONG).show();
//
//
//
//
//        }
//    }
        @Override
    public void onResume() {
        Intent i1 = getIntent();
        String res = i1.getStringExtra("result");
        Toast.makeText(this, res, Toast.LENGTH_LONG).show();
        super.onResume();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
