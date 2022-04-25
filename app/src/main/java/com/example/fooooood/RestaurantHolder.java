package com.example.fooooood;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RstrHolder extends RecyclerView.ViewHolder {
    ImageView image;
    TextView name,score;
    public RstrHolder(@NonNull View itemView) {
        super(itemView);
    }
}
