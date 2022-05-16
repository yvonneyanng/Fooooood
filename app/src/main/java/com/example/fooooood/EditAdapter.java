package com.example.fooooood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EditAdapter extends ArrayAdapter<MyMenu> {

    private Context context;
    private int res;

    public EditAdapter(@NonNull Context context, int resource, @NonNull ArrayList<MyMenu> objects) {
        super(context, resource, objects);
        this.context = context;
        this.res = resource;
    }

    @NonNull
    @Override
    // 設定 list view
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(res, parent, false);

        ImageView mealImage = convertView.findViewById(R.id.foodImg);
        TextView mealName = convertView.findViewById(R.id.foodName);
        TextView mealPrice = convertView.findViewById(R.id.foodPrice);

        // 設定 list item 裡要顯示的圖片、名稱、價錢
        mealImage.setImageResource(getItem(position).getImage());
        mealName.setText(getItem(position).getName());
        mealPrice.setText(getItem(position).getPrice());
        return convertView;
    }
}
