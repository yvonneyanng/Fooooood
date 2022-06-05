package com.example.fooooood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    String name, price;
    int image, pos;
    Button bt_update;
    EditText update_name;
    EditText update_price;
    ImageView update_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        bt_update = findViewById(R.id.update);
        update_name = findViewById(R.id.updateName);
        update_price = findViewById(R.id.updatePrice);
        update_img = findViewById(R.id.originalPhoto);

        getAndSetIntentData();
        // update meal
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(UpdateActivity.this, "更新成功", Toast.LENGTH_LONG).show();
                // go back to menu list
                Intent intent = new Intent(UpdateActivity.this, EditActivity.class);
                intent.putExtra("name", update_name.getText().toString());
                intent.putExtra("price", update_price.getText().toString());
                intent.putExtra("img", image);
                intent.putExtra("position", pos);
                startActivity(intent);
            }
        });
    }

    // display original data
    void getAndSetIntentData() {
        if(getIntent().hasExtra("position") && getIntent().hasExtra("name") && getIntent().hasExtra("price") && getIntent().hasExtra("img")){
            // get intent data
            name = getIntent().getStringExtra("name");
            price = getIntent().getStringExtra("price");
            image = getIntent().getIntExtra("img", 0);
            pos = getIntent().getIntExtra("position", 0);

            // set intent data
            update_name.setText(name);
            update_price.setText(price);
            update_img.setImageResource(image);
        }
    }
}