package com.example.fooooood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity{
    GridView gridView;
    GridView gridRowView;
    List<Restaurant> restaurantList;
    List<Restaurant> restaurantRowList;
    RestaurantAdapter restaurantAdapter, restaurantRowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getIntent();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gridView = findViewById(R.id.restaurantCol);
        gridRowView = findViewById(R.id.restaurantRow);

        restaurantList=getList();
        restaurantRowList=getRowList();

        restaurantAdapter=new RestaurantAdapter(this ,R.layout.restaurant_col,restaurantList);
        restaurantRowAdapter=new RestaurantAdapter(this,R.layout.restaurant_row,restaurantRowList);

        gridView.setAdapter(restaurantAdapter);
        gridRowView.setAdapter(restaurantRowAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(HomeActivity.this, Customer_purchase_pageActivity.class);
                startActivity(intent);
            }
        });
        gridRowView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(HomeActivity.this, Customer_purchase_pageActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Restaurant> getList() {
        restaurantList = new ArrayList<>();

        restaurantList.add(new Restaurant(1, R.drawable.pizza, "Pizzzzzzza", 5.0));
        restaurantList.add(new Restaurant(2, R.drawable.pasta, "意大利Day", 4.0));
        restaurantList.add(new Restaurant(3, R.drawable.hamburger, "Hamburgerrrrr", 3.0));

        return restaurantList;
    }

    private List<Restaurant> getRowList() {
        restaurantRowList = new ArrayList<>();

        restaurantList.add(new Restaurant(3, R.drawable.hamburger, "Hamburgerrrrr", 3.0));
        restaurantList.add(new Restaurant(2, R.drawable.noodle, "好吃的麵喔", 4.0));
        restaurantList.add(new Restaurant(1, R.drawable.pizza, "Pizzzzzzza", 5.0));

        return restaurantList;
    }

}