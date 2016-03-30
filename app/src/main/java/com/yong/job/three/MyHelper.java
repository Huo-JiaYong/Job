package com.yong.job.three;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by jyong on 2016/3/21.
 */
public class MyHelper extends SQLiteOpenHelper {

    private final String CREATE_BOOK = "CREATE TABLE book(" +
            "id integer primary key autoincrement," +
            "name text," +
            "author text," +
            "price real" +
            ")";

    private Context context;

    public MyHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        Toast.makeText(context, "CREATE TABLE SUCCESS", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
