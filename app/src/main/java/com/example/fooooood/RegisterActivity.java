package com.example.fooooood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    ToggleButton customer;
    ToggleButton restaurant;
    ToggleButton delivery;
    int toggle = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toggle = R.id.toggleButton;

        customer = (ToggleButton) findViewById(R.id.toggleButton);
        restaurant = (ToggleButton) findViewById(R.id.toggleButton3);
        delivery = (ToggleButton) findViewById(R.id.toggleButton2);

        customer.setChecked(true);
        restaurant.setChecked(false);
        delivery.setChecked(false);

        customer.setOnCheckedChangeListener(changeChecker);
        restaurant.setOnCheckedChangeListener(changeChecker);
        delivery.setOnCheckedChangeListener(changeChecker);
        reorganize();
    }

    ToggleButton.OnCheckedChangeListener changeChecker = new ToggleButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                if (compoundButton == customer) {
                    restaurant.setChecked(false);
                    delivery.setChecked(false);
                    toggle = compoundButton.getId();
                } else if (compoundButton == restaurant) {
                    customer.setChecked(false);
                    delivery.setChecked(false);
                    toggle = compoundButton.getId();
                } else if (compoundButton == delivery) {
                    customer.setChecked(false);
                    restaurant.setChecked(false);
                    toggle = compoundButton.getId();
                }
            }
            reorganize();
        }
    };
    public void reorganize() {
        TextView title=findViewById(R.id.title_register);
        RelativeLayout rn = findViewById(R.id.relativeStoreName);
        RelativeLayout rp = findViewById(R.id.relativeStorePhone);
        if (toggle == R.id.toggleButton) {//custom
            title.setText("消費者註冊");
            rn.setVisibility(View.GONE);
            rp.setVisibility(View.GONE);
        } else if (toggle == R.id.toggleButton2) {//register
            title.setText("店家註冊");
            rn.setVisibility(View.VISIBLE);
            rp.setVisibility(View.VISIBLE);
        } else {//delivery
            title.setText("外送員註冊");
            rn.setVisibility(View.GONE);
            rp.setVisibility(View.GONE);
        }
    }

    public void register(View v) {

    }

    public void goBack(View v) {
        Intent intent = getIntent();
        finish();
    }
}



