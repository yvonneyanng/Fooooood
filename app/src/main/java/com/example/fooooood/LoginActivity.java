package com.example.fooooood;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class LoginActivity extends AppCompatActivity {

    ToggleButton customer;
    ToggleButton restaurant;
    ToggleButton delivery;
    int toggle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        customer = (ToggleButton) findViewById(R.id.toggleButton);
        restaurant = (ToggleButton) findViewById(R.id.toggleButton3);
        delivery = (ToggleButton) findViewById(R.id.toggleButton2);

        customer.setChecked(false);
        restaurant.setChecked(false);
        delivery.setChecked(false);

        customer.setOnCheckedChangeListener(changeChecker);
        restaurant.setOnCheckedChangeListener(changeChecker);
        delivery.setOnCheckedChangeListener(changeChecker);
    }

    ToggleButton.OnCheckedChangeListener changeChecker = new ToggleButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b){
                if (compoundButton == customer) {
                    restaurant.setChecked(false);
                    delivery.setChecked(false);
                    toggle = compoundButton.getId();
                } else if (compoundButton == restaurant) {
                    customer.setChecked(false);
                    delivery.setChecked(false);
                    toggle = compoundButton.getId();
                } else if (compoundButton == delivery) {
                    restaurant.setChecked(false);
                    customer.setChecked(false);
                    toggle = compoundButton.getId();
                }
            }
        }
    };

    public void onGo(View v){
        Intent intent = new Intent();
        if(toggle == R.id.toggleButton){
            intent.setClass(this, HomeActivity.class);
            startActivity(intent);
        }else if(toggle == R.id.toggleButton3){
            intent.setClass(this, RestaurantMainActivity.class);
            startActivity(intent);
        }
    }
}