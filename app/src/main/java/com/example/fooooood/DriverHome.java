package com.example.fooooood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.sql.Driver;

public class DriverHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_home);
        ToggleButton onOff = findViewById(R.id.toggleButton4);
        onOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean on = ((ToggleButton)view).isChecked();

                if(on) {
                    Toast.makeText(DriverHome.this, "您已上線", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(DriverHome.this, DriverNewOrder.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(DriverHome.this, "您已下線", Toast.LENGTH_SHORT).show();
                }
            }
        });
        if(getIntent().getIntExtra("on", 0) == 1){
            onOff.setChecked(true);
        }
    }
}