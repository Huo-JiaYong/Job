package com.yong.job.three;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yong.job.R;

public class SQLiteActivity extends Activity implements View.OnClickListener {

    private Button create;
    private Button insert;
    private Button update;
    private Button delete;
    private Button select;

    private MyHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_sqlite_activity);

        helper = new MyHelper(SQLiteActivity.this, "job.db", null, 1);

        create = (Button) findViewById(R.id.create);
        insert = (Button) findViewById(R.id.insert);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        select = (Button) findViewById(R.id.select);

        create.setOnClickListener(this);
        insert.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        select.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase database;
        ContentValues values;
        switch (v.getId()) {
            case R.id.create:
                helper.getWritableDatabase();
                break;
            case R.id.insert:
                database = helper.getWritableDatabase();
                values = new ContentValues();
                values.put("name", "第一行代码");
                values.put("author", "郭霖");
                values.put("price", 22.4);
                database.insert("book", null, values);
                break;
            case R.id.update:
                database = helper.getWritableDatabase();
                values = new ContentValues();
                values.put("price", 25.3);
                database.update("book", values, "name = ?", new String[]{"第一行代码"});
                break;
            case R.id.delete:
                database = helper.getWritableDatabase();
                database.delete("book", "price < ?", new String[]{"30"});
                break;
            case R.id.select:
                database = helper.getReadableDatabase();
                Cursor cursor = database.query("book", null, null, null, null, null, null);
                StringBuilder builder = new StringBuilder();
                if (cursor.moveToFirst()) {
                    do {
                        builder.append(cursor.getString(cursor.getColumnIndex("name")) + ",");
                        builder.append(cursor.getString(cursor.getColumnIndex("author")) + ",");
                        builder.append(cursor.getFloat(cursor.getColumnIndex("price")));
                    }
                    while (cursor.moveToNext());
                    Toast.makeText(SQLiteActivity.this, builder, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SQLiteActivity.this, "没有数据读取", Toast.LENGTH_LONG).show();
                }


                break;
            default:
                break;
        }
    }
}