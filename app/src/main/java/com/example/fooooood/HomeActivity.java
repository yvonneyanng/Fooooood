package com.example.fooooood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerColView;
    RecyclerView recyclerRowView;
    RestaurantAdapter restaurantAdapter,restaurantRowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerColView = findViewById(R.id.recyclerColView);
        recyclerColView.setLayoutManager(new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerRowView =findViewById(R.id.recyclerView);
        recyclerRowView.setLayoutManager(new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.VERTICAL,false));

        restaurantAdapter = new RestaurantAdapter(this, getList(),R.layout.restaurant_col);
        recyclerColView.setAdapter(restaurantAdapter);
        restaurantRowAdapter = new RestaurantAdapter(this, getRowList(),R.layout.restaurant_row);
        recyclerRowView.setAdapter(restaurantRowAdapter);

    }

    private ArrayList<Restaurant> getList() {
        ArrayList<Restaurant> restaurantList = new ArrayList<>();

        restaurantList.add(new Restaurant(1, R.drawable.pizza, "Pizzzzzzza", 5.0));
        restaurantList.add(new Restaurant(2, R.drawable.pasta, "意大利Day", 4.0));
        restaurantList.add(new Restaurant(3, R.drawable.hamburger, "Hamburgerrrrr", 3.0));

        return restaurantList;
    }

    private ArrayList<Restaurant> getRowList() {
        ArrayList<Restaurant> restaurantList = new ArrayList<>();

        restaurantList.add(new Restaurant(3, R.drawable.hamburger, "Hamburgerrrrr", 3.0));
        restaurantList.add(new Restaurant(2, R.drawable.noodle, "好吃的麵喔", 4.0));
        restaurantList.add(new Restaurant(1, R.drawable.pizza, "Pizzzzzzza", 5.0));

        return restaurantList;
    }
}