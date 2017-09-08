package com.example.riyaz.viewpagerexample2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

/**
 * Created by Riyaz on 6/21/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MainViewHolder> {

    String country[],capital[];
    List<Data> data;
    Bundle extras;
    public static final int zero = 1;
    public static final int one = 2;
//    public RecyclerAdapter(String[] country, String[] capital, List<Data> data){
public RecyclerAdapter( List<Data> data){
//        this.country = country;
//        this.capital = capital;
        this.data = data;
    }



    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        MainViewHolder mainViewHolder= new MainViewHolder(view);

        return mainViewHolder;

    }


    @Override
    public void onBindViewHolder(final MainViewHolder holder, final int position) {
        holder.tx_country.setText(data.get(position).country);
        holder.tx_capital.setText(data.get(position).capital);
        holder.image.setImageResource(data.get(position).imageId);
        extras = new Bundle();
        holder.tx_capital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(),holder.tx_capital.getText().toString(),Toast.LENGTH_LONG).show();
                Intent i = new Intent(view.getContext(),DisplayInfo.class);
                extras.putString("CAPITAL_NAME",(holder.tx_capital.getText()).toString());
                extras.putString("COUNTRY_NAME",(holder.tx_country.getText()).toString());
                extras.putString("IMAGE",(data.get(position).txt.toString()).toString());
//                int image_Number = data.get(position).imageId;
//                extras.putInt("Image",image_Number);
                i.putExtras(extras);
                view.getContext().startActivity(i);

//                ((Activity) view.getContext()).startActivityForResult(i,1);

            }
        });
        holder.tx_country.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(),holder.tx_country.getText().toString(),Toast.LENGTH_LONG).show();
                Intent i = new Intent(view.getContext(),DisplayInfo.class);
                extras.putString("CAPITAL_NAME",(holder.tx_capital.getText()).toString());
                extras.putString("COUNTRY_NAME",(holder.tx_country.getText()).toString());
                extras.putString("IMAGE",(data.get(position).txt.toString()).toString());
                i.putExtras(extras);
                view.getContext().startActivity(i);
//                ((Activity) view.getContext());
            }
        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), data.get(position).txt.toString(),Toast.LENGTH_LONG).show();
                Intent i = new Intent(view.getContext(),DisplayInfo.class);
                extras.putString("CAPITAL_NAME",(holder.tx_capital.getText()).toString());
                extras.putString("COUNTRY_NAME",(holder.tx_country.getText()).toString());
                extras.putString("IMAGE",(data.get(position).txt.toString()).toString());

                i.putExtras(extras);
                view.getContext().startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();

    }



    public class MainViewHolder extends RecyclerView.ViewHolder{
        TextView tx_country,tx_capital;
        ImageView image;
        public MainViewHolder(View view){
            super(view);
            tx_country = (TextView)view.findViewById(R.id.country);
            tx_capital = (TextView)view.findViewById(R.id.capital);
            image = (ImageView)view.findViewById(R.id.image);


        }
    }

}

