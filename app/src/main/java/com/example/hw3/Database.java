package com.example.hw3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "hw3.db";
    public static final String TABLE_NAME = "CAR";

    // COLUMNS

    public static final String COLS_1 = "ID";
    public static final String COLS_2 = "MAKE";
    public static final String COLS_3 = "MODEL";
    public static final String COLS_4 = "YEAR";
    public static final String COLS_5 = "MILEAGE";
    public static final String COLS_6 = "PRICE";



    public Database(@Nullable Context context) {
       super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT,make TEXT, model TEXT, year integer,mileage integer, price integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public ArrayList llenar_lista(){
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;
        Cursor registers = database.rawQuery(query,null);
        if (registers.moveToFirst()){
            do{
                list.add(registers.getString(0)
                +" "+ registers.getString(1)
                                +" "+ registers.getString(2)
                                +" "+ registers.getString(3)
                                +" "+ registers.getString(4)
                                +" "+ registers.getString(5)

                );
            }while(registers.moveToNext());
        }
    return list;

    }
}
