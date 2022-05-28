package com.example.fooooood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MenuDatabaseHelper extends SQLiteOpenHelper {

    public static final String db_name = "MealsDB";
    public static final int db_version = 1;

    public MenuDatabaseHelper(@Nullable Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS meals (name VARCAHR(10), price VARCHAR(10), image int(100))"); // 建立餐點資料庫
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS meals");
        onCreate(db);
    }

    void addItem(int image, String name, String price) {
        // set content
        ContentValues cv = new ContentValues();
        cv.put("image", image);
        cv.put("name", name);
        cv.put("price", "$ " + price);

        // insert to database
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("meals", null, cv);
    }

    Cursor readAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery("SELECT * FROM meals", null);
        }
        return cursor;
    }
}
