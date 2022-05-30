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
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    RecyclerView rcvMenu;
    FloatingActionButton btnFloating;
    MenuAdapter menuAdapter;
    EditText etName, etPrice;
    MenuDatabaseHelper myDB;
    ArrayList<String> mealName, mealPrice, mealId;
    ArrayList<Integer> mealImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btnFloating = findViewById(R.id.add);
        rcvMenu = findViewById(R.id.rv_menu);

        myDB = new MenuDatabaseHelper(EditActivity.this);
        mealId = new ArrayList<>();
        mealImg = new ArrayList<>();
        mealName = new ArrayList<>();
        mealPrice = new ArrayList<>();
        storeDataInArrays();
        menuAdapter = new MenuAdapter(EditActivity.this, this,  mealId, mealImg, mealName, mealPrice);
        rcvMenu.setLayoutManager(new LinearLayoutManager(EditActivity.this));
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
                ImageView ibtAdd = dialog.findViewById(R.id.takePhoto);

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
                            MenuDatabaseHelper menuDatabase = new MenuDatabaseHelper(EditActivity.this);
                            menuDatabase.addItem(etName.getText().toString(), etPrice.getText().toString(), R.drawable.wtf);
                            finish();
                            startActivity(getIntent());
                            dialog.dismiss();
                        }
                    }
                });

                // camera
                ibtAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
            }
        });
    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "您的菜單是空的！", Toast.LENGTH_LONG).show();
        } else {
            while(cursor.moveToNext()){
                mealId.add(cursor.getString(0));
                mealName.add(cursor.getString(1));
                mealPrice.add(cursor.getString(2));
                mealImg.add(cursor.getInt(3));
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){ // code for displaying new data after update
            recreate();
        }
    }
}