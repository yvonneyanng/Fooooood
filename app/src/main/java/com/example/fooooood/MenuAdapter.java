package com.example.fooooood;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>{

    Context context;
    ArrayList mealName, mealPrice, mealImg, mealId;
    Activity activity;

    MenuAdapter(Activity activity, Context context, ArrayList mealId, ArrayList mealImg, ArrayList mealName, ArrayList mealPrice){
        this.activity = activity;
        this.mealId = mealId;
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
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(mealId.get(holder.getAdapterPosition())));
                intent.putExtra("name", String.valueOf(mealName.get(holder.getAdapterPosition())));
                intent.putExtra("price", String.valueOf(mealPrice.get(holder.getAdapterPosition())));
                intent.putExtra("image", (Integer) mealImg.get(holder.getAdapterPosition()));
                activity.startActivityForResult(intent, 1);
            }
        });
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
            cardView = itemView.findViewById(R.id.itemCard);
        }
    }
}
