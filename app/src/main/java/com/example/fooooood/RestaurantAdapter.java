package com.example.fooooood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantHolder> {
    Context context;
    ArrayList<Restaurant> restaurants;
    int layout;
    public RestaurantAdapter(Context context, ArrayList<Restaurant> restaurants,int layout) {
        this.context = context;
        this.restaurants = restaurants;
        this.layout=layout;
    }

    @NonNull
    @Override
    public RestaurantHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null);
        return new RestaurantHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantHolder holder, int position) {
        holder.image.setImageResource(restaurants.get(position).getImage());
        holder.name.setText(restaurants.get(position).getName());
        holder.score.setText(restaurants.get(position).getScore());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }
}
