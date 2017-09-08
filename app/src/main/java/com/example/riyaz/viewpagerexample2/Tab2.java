package com.example.riyaz.viewpagerexample2;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Riyaz on 6/23/2017.
 */

//Our class extending fragment
public class Tab2 extends Fragment implements SeekBar.OnSeekBarChangeListener{
    //Permision code that will be checked in the method onRequestPermissionsResult
    private int STORAGE_PERMISSION_CODE = 23;

    SeekBar seekBar;
    final Random rnd = new Random();
    Context context;
    ImageView img;
    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2, container, false);
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes

        seekBar = (SeekBar)view.findViewById(R.id.seekBar1);
        img = (ImageView) view.findViewById(R.id.imgRandom);

        seekBar.setOnSeekBarChangeListener(this);
        return view;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (isReadStorageAllowed()) {
            //If permission is already having then showing the toast
            Toast.makeText(getActivity(), "You already have the permission", Toast.LENGTH_LONG).show();
            //Existing the method with return
            return;
        }

        //If the app has not the permission then asking for the permission
        requestStoragePermission();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (isReadStorageAllowed()) {
            //If permission is already having then showing the toast
            //  Toast.makeText(MainActivity.this, "You already have the permission", Toast.LENGTH_LONG).show();
            //Existing the method with return


            final String str = "img_" + rnd.nextInt(7);

            int id = getResources().getIdentifier(str, "drawable", getActivity().getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            img.setImageDrawable(drawable);
            return;
        }

        //If the app has not the permission then asking for the permission
        requestStoragePermission();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    //We are calling this method to check the permission status
    private boolean isReadStorageAllowed() {
        //Getting the permission status
        int result = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);

        //If permission is granted returning true
        if (result == PackageManager.PERMISSION_GRANTED)
            return true;

        //If permission is not granted returning false
        return false;
    }

    //Requesting permission
    private void requestStoragePermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }

    //This method will be called when the user will tap on allow or deny
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        //Checking the request code of our request
        if (requestCode == STORAGE_PERMISSION_CODE) {

            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                //Displaying a toast
                Toast.makeText(getActivity(), "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
            } else {
                //Displaying another toast if permission is not granted
                Toast.makeText(getActivity(), "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }

}