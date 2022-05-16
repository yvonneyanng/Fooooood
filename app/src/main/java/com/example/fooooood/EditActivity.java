package com.example.fooooood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    private RecyclerView rcvMenu;
    private FloatingActionButton btnFloating;
    private MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        rcvMenu = findViewById(R.id.rv_menu);
        menuAdapter = new MenuAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvMenu.setLayoutManager(linearLayoutManager);
        menuAdapter.setData(getListUser());
        rcvMenu.setAdapter(menuAdapter);

        // back to main page
        TextView textBack = (TextView) findViewById(R.id.back_edit);
        textBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, RestaurantMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
    private List<Menu> getListUser() {
        List<Menu> list = new ArrayList<>();
        list.add(new Menu(R.drawable.meat, "肉醬", "$ 150"));
        list.add(new Menu(R.drawable.seafood, "海鮮", "$ 180"));
        list.add(new Menu(R.drawable.pizza_hawaiian, "夏威夷", "$ 170"));
        list.add(new Menu(R.drawable.coke, "可樂", "$ 20"));
        return list;
    }
}