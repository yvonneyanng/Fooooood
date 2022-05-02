package com.example.fooooood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fooooood.Restaurant;
import com.example.fooooood.RestaurantMainActivity;

public class EditActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String s_flavors[], s_price[];
    int images[] = {R.drawable.meat, R.drawable.seafood};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        TextView textBack = (TextView) findViewById(R.id.back_edit);
        // back to main page
        textBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, RestaurantMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

//        recyclerView = findViewById(R.id.recyclerView);
//        s_flavors = getResources().getStringArray(R.array.flavors);
//        s_price = getResources().getStringArray(R.array.price);
//
//        EditAdapter editAdapter = new EditAdapter(this, s_flavors, s_price, images);
//        recyclerView.setAdapter(editAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}