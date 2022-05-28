package com.example.fooooood;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{

    Context context;
    ArrayList mealName, mealPrice;
    ArrayList mealImg;

    MenuAdapter(Context context, ArrayList mealImg, ArrayList mealName, ArrayList mealPrice){
        this.context = context;
        this.mealImg = mealImg;
        this.mealName = mealName;
        this.mealPrice = mealPrice;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.edit_row, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.img.setImageResource((Integer) mealImg.get(position));
        holder.name.setText(String.valueOf(mealName.get(position)));
        holder.price.setText(String.valueOf(mealPrice.get(position)));
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(EditActivity.class, "請輸入價格", Toast.LENGTH_LONG).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mealName.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name;
        TextView price;
        CardView cardView;

        public MenuViewHolder(@NonNull View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.foodImg);
            name = itemView.findViewById(R.id.foodName);
            price = itemView.findViewById(R.id.foodPrice);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
