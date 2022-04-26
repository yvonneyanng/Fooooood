package com.example.fooooood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        TextView textBack = (TextView) findViewById(R.id.back_edit);
        // back to main page
        textBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, RestaurantMainActivity.class);
                startActivity(intent);
            }
        });
    }
}