package com.example.fooooood;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RestaurantHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView name,score;
    public RestaurantHolder(@NonNull View itemView) {
        super(itemView);

        this.image=itemView.findViewById(R.id.imageView);
        this.name=itemView.findViewById(R.id.restaurantName);
        this.score=itemView.findViewById(R.id.score);

    }
}
