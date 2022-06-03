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

    String name, price, id;
    int image;
    Button bt_update;
    Button bt_delete;
    EditText update_name;
    EditText update_price;
    ImageView update_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        bt_update = findViewById(R.id.update);
        bt_delete = findViewById(R.id.delete);
        update_name = findViewById(R.id.updateName);
        update_price = findViewById(R.id.updatePrice);
        update_img = findViewById(R.id.originalPhoto);

        getAndSetIntentData();
        // update meal
        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // update database
                MenuDatabaseHelper myDB = new MenuDatabaseHelper(UpdateActivity.this);
                myDB.updateData(id, name, price, image);

                Toast.makeText(UpdateActivity.this, "更新成功", Toast.LENGTH_LONG).show();
                // go back to menu list
                Intent intent = new Intent(UpdateActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });

        // delete meal
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UpdateActivity.this, "刪除成功", Toast.LENGTH_LONG).show();
                // go back to menu list
                Intent intent = new Intent(UpdateActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });
    }

    // display original data
    void getAndSetIntentData() {
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("price") && getIntent().hasExtra("image")){
            // get intent data
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            price = getIntent().getStringExtra("price");
            image = getIntent().getIntExtra("image", 0);

            // set intent data
            update_name.setText(name);
            update_price.setText(price.substring(2));
            update_img.setImageResource(image);
        }
    }
}