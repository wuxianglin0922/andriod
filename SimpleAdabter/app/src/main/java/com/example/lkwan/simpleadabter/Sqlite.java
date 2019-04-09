package com.example.lkwan.simpleadabter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite  extends SQLiteOpenHelper {
    //final String SHU_JU_KU="create table xu(_id integer primary key autoincrement,shuju_1)";

    public Sqlite( Context context) {
        super( context, "money.db", null, 1 );
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create table dict(_id integer primary key autoincrement,word,detail
        //sqLiteDatabase.execSQL( SHU_JU_KU );
        sqLiteDatabase.execSQL( "create table money(_id integer primary key autoincrement,name,timer,adress,phone)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
