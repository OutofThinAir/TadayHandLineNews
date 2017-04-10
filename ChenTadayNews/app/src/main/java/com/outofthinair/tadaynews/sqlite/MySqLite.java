package com.outofthinair.tadaynews.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/3/21.
 */

public class MySqLite extends SQLiteOpenHelper {
    public MySqLite(Context context) {
        super(context, "tadaynews", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //建表
        String sqlshoucang="create table shoucang (_id integer primary key autoincrement,title varchar(10) not null," +
                "info varchar(10) not null, picurl varchar(10),partiurl varchar(10))" ;
        String sqluser = "create table user (_id integer primary key autoincrement,uname varchar(10) not null," +
                "picurl varchar(10), logig varchar(10) not null )";
        db.execSQL(sqlshoucang);
        db.execSQL(sqluser);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
