package com.example.fooooood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    private RecyclerView rcvMenu;
    private FloatingActionButton btnFloating;
    private MenuAdapter menuAdapter;
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

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeItem(menuAdapter));
        itemTouchHelper.attachToRecyclerView(rcvMenu);

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
                Button btCancel = dialog.findViewById(R.id.cancel);

                dialog.show();
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                if(dialog.getWindow() != null){
                    WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
                    lp.width = 900;
                    dialog.getWindow().setAttributes(lp);
                }
                btConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (TextUtils.isEmpty(etName.getText().toString()) && TextUtils.isEmpty(etPrice.getText().toString())){
                            Toast.makeText(EditActivity.this, "欄位不可為空白", Toast.LENGTH_LONG).show();
                        } else if (TextUtils.isEmpty(etName.getText().toString())){
                            Toast.makeText(EditActivity.this, "請輸入餐點名稱", Toast.LENGTH_LONG).show();
                        } else if (TextUtils.isEmpty(etPrice.getText().toString())){
                            Toast.makeText(EditActivity.this, "請輸入價格", Toast.LENGTH_LONG).show();
                        } else {
                            list.add(new Menu(R.drawable.unknown, etName.getText().toString(), "$ " + etPrice.getText().toString()));
                            dialog.dismiss();
                        }
                    }
                });
                btCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });
    }
    private List<Menu> getListUser() {
        list.add(new Menu(R.drawable.meat, "肉醬", "$ 150"));
        list.add(new Menu(R.drawable.seafood, "海鮮", "$ 180"));
        list.add(new Menu(R.drawable.pizza_hawaiian, "夏威夷", "$ 170"));
        list.add(new Menu(R.drawable.coke, "可樂", "$ 20"));
        list.add(new Menu(R.drawable.pizza_mashroon2, "蘑菇", "$ 130"));
        list.add(new Menu(R.drawable.pizzafst, "總匯", "$ 150"));
        return list;
    }
}