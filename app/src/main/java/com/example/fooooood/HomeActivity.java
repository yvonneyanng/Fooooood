package com.example.fooooood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RestaurantAdapter restaurantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, true));

        restaurantAdapter = new RestaurantAdapter(this, getList());
    }

    private ArrayList<Restaurant> getList() {
        ArrayList<Restaurant> restaurantList = new ArrayList<>();

        restaurantList.add(new Restaurant(1, R.drawable.pizza, "Pizzzzzzza", 5.0));
        restaurantList.add(new Restaurant(2, R.drawable.pasta, "Pizzzzzzza", 5.0));
        return restaurantList;
    }
}