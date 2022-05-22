package com.example.fooooood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {
    Context context;
    List<Restaurant> restaurants;
    int layout;

    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull List<Restaurant> restaurants) {
        super(context, resource, restaurants);
        this.context = context;
        this.restaurants = restaurants;
        this.layout = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        LinearLayout restaurantLayout;
        if (convertView == null) {
            restaurantLayout = (LinearLayout) inflater.inflate(layout, null);
        } else {
            restaurantLayout = (LinearLayout) convertView;
        }

        Restaurant res = restaurants.get(position);
        ImageView iv = restaurantLayout.findViewById(R.id.imageView);
        iv.setImageResource(res.getImage());
        TextView tv = restaurantLayout.findViewById(R.id.restaurantName);
        tv.setText(res.getName());
        TextView tv2 = restaurantLayout.findViewById(R.id.score);
        tv2.setText(res.getScore());
        return restaurantLayout;

    }
}
