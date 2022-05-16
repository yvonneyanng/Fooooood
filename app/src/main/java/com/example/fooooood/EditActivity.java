package com.example.fooooood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fooooood.Restaurant;
import com.example.fooooood.RestaurantMainActivity;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    TextView tv_name;
    TextView tv_price;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
//        tv_name = findViewById(R.id.foodName);
//        tv_price = findViewById(R.id.foodPrice);
        listView = findViewById(R.id.lv_menu);
        ArrayList<MyMenu> arrayList = new ArrayList<>();

        arrayList.add(new MyMenu(R.drawable.meat, "肉醬", "$ 180"));
        arrayList.add(new MyMenu(R.drawable.seafood, "海鮮", "$ 150"));
        arrayList.add(new MyMenu(R.drawable.pizza_hawaiian, "夏威夷", "$ 170"));
        arrayList.add(new MyMenu(R.drawable.coke, "可樂", "$ 20"));

        // custom adapter
        EditAdapter menuAdapter = new EditAdapter(this, R.layout.edit_row, arrayList);
        listView.setAdapter(menuAdapter);

        TextView textBack = (TextView) findViewById(R.id.back_edit);
        // back to main page
        textBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, RestaurantMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}