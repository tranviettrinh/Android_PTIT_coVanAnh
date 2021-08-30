package com.example.b17dcat191tranviettrinh.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;

import com.example.b17dcat191tranviettrinh.Models.MonAn_B17DCAT191;

import java.util.ArrayList;
import java.util.List;

public class B17DCAT191_QUANLYTHUCDON extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "B17DCAT191_QUANLYTHUCDON";
    private static final int DATABASE_VERSION = 1;

    private static final String MON_TABLE = "mon_table";
    private static final String MON_ID = "mon_id";
    private static final String MON_NAME = "mon_name";
    private static final String MON_PRICE = "mon_price";
    private static final String MON_TIME = "mon_time";

    private static final String LOAI_TABLE = "loai_table";
    private static final String LOAI_ID = "loai_id";
    private static final String LOAI_NAME = "loai_name";
    private static final String LOAI_DES = "loai_des";

    public B17DCAT191_QUANLYTHUCDON(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableMon = "CREATE TABLE " + MON_TABLE + " (" +
                MON_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MON_NAME + " TEXT, " +
                MON_PRICE + " INTEGER, " +
                MON_TIME + " TEXT)";
        db.execSQL(createTableMon);

        String createTableLoai = "CREATE TABLE " + LOAI_TABLE + " (" +
                LOAI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LOAI_NAME + " TEXT, " +
                LOAI_DES + " TEXT)";
        db.execSQL(createTableLoai);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion >oldVersion){
            db.execSQL("DROP TABLE IF EXISTS " + MON_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + LOAI_TABLE);
            onCreate(db);
        }
    }

    public boolean addMon(MonAn_B17DCAT191 mon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MON_NAME, mon.getName());
        values.put(MON_PRICE, mon.getPrice());
        values.put(MON_TIME, mon.getTime());
        long kq = db.insert(MON_TABLE, null, values);
        db.close();
        return kq > 0;
    }

    public List<MonAn_B17DCAT191> getAllMon() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + MON_TABLE;
        List<MonAn_B17DCAT191> data = new ArrayList<>();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            MonAn_B17DCAT191 mon = new MonAn_B17DCAT191(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getString(3)
            );
            data.add(mon);
            cursor.moveToNext();
        }
        db.close();
        return data;
    }
}
