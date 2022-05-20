package com.example.fooooood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    private RecyclerView rcvMenu;
    private FloatingActionButton btnFloating;
    private MenuAdapter menuAdapter;
    String name, price;
    List<Menu> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        rcvMenu = findViewById(R.id.rv_menu);
        btnFloating = findViewById(R.id.add);
        menuAdapter = new MenuAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvMenu.setLayoutManager(linearLayoutManager);
        menuAdapter.setData(getListUser());
        rcvMenu.setAdapter(menuAdapter);

        // hide and show the floating action button while scrolling
        rcvMenu.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if(dy > 0){
                    btnFloating.hide();
                } else {
                    btnFloating.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        // back to main page
        TextView textBack = (TextView) findViewById(R.id.back_edit);
        textBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, RestaurantMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(EditActivity.this);
                dialog.setContentView(R.layout.edit_menu);

                EditText etName = dialog.findViewById(R.id.addName);
                EditText etPrice = dialog.findViewById(R.id.addPrice);
                Button btConfirm = dialog.findViewById(R.id.confirm);

                btConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        list.add(new Menu(R.drawable.unknown, etName.getText().toString(), "$ " + etPrice.getText().toString()));
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
    private List<Menu> getListUser() {
//        List<Menu> list = new ArrayList<>();
        list.add(new Menu(R.drawable.meat, "肉醬", "$ 150"));
        list.add(new Menu(R.drawable.seafood, "海鮮", "$ 180"));
        list.add(new Menu(R.drawable.pizza_hawaiian, "夏威夷", "$ 170"));
        list.add(new Menu(R.drawable.coke, "可樂", "$ 20"));
        list.add(new Menu(R.drawable.pizza_mashroon2, "蘑菇", "$ 130"));
        list.add(new Menu(R.drawable.pizzafst, "總匯", "$ 150"));
        return list;
    }
}