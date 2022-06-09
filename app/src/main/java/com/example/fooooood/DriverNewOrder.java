package com.example.fooooood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class DriverNewOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_new_order);

        Button accept = findViewById(R.id.button6);
        Button decline = findViewById(R.id.button7);
        Button complete = findViewById(R.id.button9);
        ImageView back = findViewById(R.id.back);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                complete.setVisibility(View.VISIBLE);
                accept.setVisibility(View.GONE);
                decline.setVisibility(View.GONE);
            }
        });
        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accept.setVisibility(View.GONE);
                decline.setVisibility(View.GONE);
                Toast.makeText(DriverNewOrder.this, "您已拒絕此訂單", Toast.LENGTH_SHORT).show();
            }
        });
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                complete.setVisibility(View.GONE);
                Toast.makeText(DriverNewOrder.this, "您已完成此訂單", Toast.LENGTH_SHORT).show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(DriverNewOrder.this, DriverHome.class);
                intent.putExtra("on", 1);
                startActivity(intent);
            }
        });
    }
}