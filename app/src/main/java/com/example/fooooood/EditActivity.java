package com.example.fooooood;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    RecyclerView rcvMenu;
    FloatingActionButton btnFloating;
    MenuAdapter menuAdapter;
    String name;
    String price;
    int image;
    int pos;

    EditText etName, etPrice;
    List<Menu> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnFloating = findViewById(R.id.add);
        rcvMenu = findViewById(R.id.rv_menu);

        menuAdapter = new MenuAdapter();
        rcvMenu.setLayoutManager(new LinearLayoutManager(EditActivity.this));
        menuAdapter.setData(getListMenu());
        rcvMenu.setAdapter(menuAdapter);

        getAndSetIntentData();
        menuAdapter.OnRecyclerViewClickListener(new MenuAdapter.OnRecyclerViewClickListener() {
            @Override
            public void OnItemClick(int position) {
                Intent intent = new Intent(EditActivity.this, UpdateActivity.class);
                intent.putExtra("name", list.get(position).getMealName());
                intent.putExtra("price", list.get(position).getMealPrice());
                intent.putExtra("img", list.get(position).getMealImg());
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

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

        // 回到主頁
        ImageView backToMain = findViewById(R.id.back2);
        backToMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this, RestaurantMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        // 新增餐點
        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(EditActivity.this);
                dialog.setContentView(R.layout.edit_menu);

                etName = dialog.findViewById(R.id.addName);
                etPrice = dialog.findViewById(R.id.addPrice);
                Button btConfirm = dialog.findViewById(R.id.confirm);

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
                            Toast.makeText(EditActivity.this, "欄位不可空白", Toast.LENGTH_LONG).show();
                        } else if (TextUtils.isEmpty(etName.getText().toString())){
                            Toast.makeText(EditActivity.this, "請輸入餐點名稱", Toast.LENGTH_LONG).show();
                        } else if (TextUtils.isEmpty(etPrice.getText().toString())){
                            Toast.makeText(EditActivity.this, "請輸入價格", Toast.LENGTH_LONG).show();
                        } else {
                            list.add(new Menu(etName.getText().toString(), etPrice.getText().toString(), R.drawable.unknown));
                            dialog.dismiss();
                        }
                    }
                });
            }
        });
    }

    private List<Menu> getListMenu() {

        list.add(new Menu("牛肉", "200", R.drawable.beef));
        list.add(new Menu("肉醬", "150", R.drawable.meat));
        list.add(new Menu("可樂", "20", R.drawable.coke));
        list.add(new Menu("可爾必思", "30", R.drawable.calpis));
        list.add(new Menu("海鮮", "130", R.drawable.seafood));
        return list;
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
            Menu newData = new Menu(name, price, image);
            list.set(pos, newData);
        }
    }
}