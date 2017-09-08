package com.example.riyaz.viewpagerexample2;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Riyaz on 6/23/2017.
 */

//Our class extending fragment
public class Tab1 extends Fragment {

    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    MenuItem shuffle;
    private ShareActionProvider sharedAction;
    RecyclerView.LayoutManager layoutManager;
    private List<Data> data = new ArrayList<>();
    private List<Data> data1 = new ArrayList<>();
    DisplayInfo displayInfo;
    final int RC = 17;
    View mv;
    static String temp = null;
//    String[] country = {"India", "USA", "Pakistan", "China", "Egypt", "Canada", "Malysia", "UAE", "UK",
//            "France", "Poland", "Greece", "Mexico", "Spain", "Australia"};
//    String[] capital = {"Delhi", "Washington", "Islamabad", "Bejing", "Cairo", "Toronto", "Mala", "Abu dhabi",
//            "London", "Paris", "poland", "Athens", "Mexico City", "Barcelona", "Sydney"};
//    int[] pics = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6,
//            R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10, R.drawable.img11, R.drawable.img12, R.drawable.img13, R.drawable.img14, R.drawable.img15,
//    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        shuffle = (MenuItem) getActivity().findViewById(R.id.shuffle);
        sharedAction = (ShareActionProvider) MenuItemCompat.getActionProvider(shuffle);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.shuffle) {
        askPermission(android.Manifest.permission.CAMERA, RC);
        }
//        else if (item.getItemId()==R.id.sort){
//            sort(android.Manifest.permission.CAMERA, RC);
//        }
        return super.onOptionsItemSelected(item);
    }


    private void askPermission(final String permission, final int requestCode) {
        if (ContextCompat.checkSelfPermission(getActivity(), permission) != PackageManager.PERMISSION_GRANTED) {

            if (!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.CAMERA)) {
                Toast.makeText(getActivity(), "Please go to Setting & Change Permissions", Toast.LENGTH_LONG).show();
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.CAMERA)) {
                Snackbar.make(mv, "Please Give Permission...", Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityCompat.requestPermissions(getActivity(), new String[]{permission}, requestCode);
                    }
                }).show();
            }
        } else {
            data.add(new Data(R.drawable.img1, "india", "India", "Delhi"));
            data.add(new Data(R.drawable.img2, "usa","USA", "washington"));
            data.add(new Data(R.drawable.img3, "pakistan", "Pakistan", "Islamabad"));
            data.add(new Data(R.drawable.img4, "china", "China", "Bejing"));
            data.add(new Data(R.drawable.img5, "egypt", "Egypt", "Cairo"));
            data.add(new Data(R.drawable.img6, "canada", "Canada", "Toronto"));
            data.add(new Data(R.drawable.img7, "malaysia", "Malaysia", "Kuala Lampur"));
            data.add(new Data(R.drawable.img8, "uae","UAE", "Abu Dhabi"));
            data.add(new Data(R.drawable.img9, "uk", "UK", "London"));
            data.add(new Data(R.drawable.img10, "france", "Frabce", "Paris"));
            data.add(new Data(R.drawable.img11, "poland", "Poland", "poland"));
            data.add(new Data(R.drawable.img12, "greece", "Greece", "Athens"));
            data.add(new Data(R.drawable.img13, "mexico", "Mexico", "Mexico City"));
            data.add(new Data(R.drawable.img14, "spain", "Spain", "Barcelona"));
            data.add(new Data(R.drawable.img15, "australia", "Autralia", "Sydney"));

//            int[] rimage = new int[15];
//            String[] country_temp = new String[15];
//            String[] capital_temp = new String[15];
//            int[] pics_temp = new int[15];
            Random r = new Random();

            for (int i = 0; i < 15; i++) {
                int n = r.nextInt(15);
//                pics_temp[i] = pics[n];
//                country_temp[i] = country[n];
//                capital_temp[i] = capital[n];
//                data1.get(n);

            }
//            data.clear();
//            for (int i = 0; i < 15; i++) {
//                data.add(new Data(pics_temp[i], country_temp[i]));
//            }


            recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
            adapter = new RecyclerAdapter( data1);
            recyclerView.setAdapter(adapter);
            layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            Toast.makeText(getActivity(), "Permission has already granted", Toast.LENGTH_LONG).show();

        }
    }


    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.tab1, container, false);

        data.add(new Data(R.drawable.img1, "india", "India", "Delhi"));
        data.add(new Data(R.drawable.img2, "usa","USA", "washington"));
        data.add(new Data(R.drawable.img3, "pakistan", "Pakistan", "Islamabad"));
        data.add(new Data(R.drawable.img4, "china", "China", "Bejing"));
        data.add(new Data(R.drawable.img5, "egypt", "Egypt", "Cairo"));
        data.add(new Data(R.drawable.img6, "canada", "Canada", "Toronto"));
        data.add(new Data(R.drawable.img7, "malaysia", "Malaysia", "Kuala Lampur"));
        data.add(new Data(R.drawable.img8, "uae","UAE", "Abu Dhabi"));
        data.add(new Data(R.drawable.img9, "uk", "UK", "London"));
        data.add(new Data(R.drawable.img10, "france", "Frabce", "Paris"));
        data.add(new Data(R.drawable.img11, "poland", "Poland", "poland"));
        data.add(new Data(R.drawable.img12, "greece", "Greece", "Athens"));
        data.add(new Data(R.drawable.img13, "mexico", "Mexico", "Mexico City"));
        data.add(new Data(R.drawable.img14, "spain", "Spain", "Barcelona"));
        data.add(new Data(R.drawable.img15, "australia", "Autralia", "Sydney"));


        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        adapter = new RecyclerAdapter(data);
        recyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        return view;

    }


    @Override
    public void onResume() {

        Intent i1 = getActivity().getIntent();
        String res = i1.getStringExtra("result");

        if (res != null && temp != i1.getStringExtra("result")) {
            Toast.makeText(this.getActivity(), res, Toast.LENGTH_LONG).show();
            temp = i1.getStringExtra("result");
        }
        super.onResume();
    }
}