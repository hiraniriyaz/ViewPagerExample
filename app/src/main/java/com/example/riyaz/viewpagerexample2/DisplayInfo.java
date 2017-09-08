package com.example.riyaz.viewpagerexample2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

/**
 * Created by Riyaz on 6/23/2017.
 */

public class DisplayInfo extends AppCompatActivity{
    TextView txt_info;
    EditText edit_info;
    Button button;
    ImageView img_animal;
    Bundle extras1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_on_click);
        txt_info = (TextView)findViewById(R.id.txt_info);
        edit_info = (EditText)findViewById(R.id.edit_info);
        button = (Button)findViewById(R.id.button);
        img_animal = (ImageView)findViewById(R.id.img_info);
        extras1 = new Bundle();

        Intent i = getIntent();
        final Bundle extras = i.getExtras();
        String country_name = extras.getString("COUNTRY_NAME");
        String capital_name = extras.getString("CAPITAL_NAME");
        String image = extras.getString("IMAGE");

//        final String str = "img_" + rnd.nextInt(7);

        int id = getResources().getIdentifier(image, "drawable",DisplayInfo.this.getPackageName());
        Drawable drawable = getResources().getDrawable(id);
        img_animal.setImageDrawable(drawable);
//        int image_Number = extras.getInt("image");
//        String temp = "R.Drawable." + extras.getString("IMAGE")+".jpg";
        txt_info.setText("Country Name:"+country_name+"   \n"+"Capital City:"+ capital_name);
////        File drawableFile = new File(getApplicationContext().getFilesDir().getAbsolutePath()+"/" +image.toString() +".jpg");
//        img_animal.setImageDrawable(Drawable.createFromPath(temp));
////        img_animal.setImageDrawable(Drawable.createFromPath(drawableFile.getAbsolutePath()));



//        img_animal.setImageDrawable(image_Number);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayInfo.this,MainActivity.class);
                intent.putExtra("result",edit_info.getText().toString());
                startActivity(intent);
            }
        });


    }
}
