package com.example.fooooood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MenuDatabaseHelper extends SQLiteOpenHelper {

    public static final String db_name = "MealsDB";
    public static final String tableName = "meals";
    public static final String columnID = "id";
    public static final String columnName = "name";
    public static final String columnPrice = "price";
    public static final String columnImg = "image";
    public static final int db_version = 1;

    MenuDatabaseHelper(@Nullable Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + tableName +
                " (" + columnID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                columnName + " TEXT, " +
                columnPrice + " TEXT, " +
                columnImg + " INTEGER);";
        db.execSQL(query); // 建立餐點資料庫
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS meals");
        onCreate(db);
    }

    // add new meal
    void addItem(String name, String price, int image) {
        // set content
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("price", price);
        cv.put("image", image);

        // insert to database
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("meals", null, cv);
    }

    // update meal
    void updateData(String row_id, String newName, String newPrice, int newImage) {
        ContentValues cv = new ContentValues();
        cv.put("name", newName);
        cv.put("price", newPrice);
        cv.put("image", newImage);

        // update the database
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(tableName, cv, "id=?", new String[]{row_id});
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
