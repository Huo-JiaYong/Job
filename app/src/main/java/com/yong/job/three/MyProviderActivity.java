package com.yong.job.three;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yong.job.R;

public class MyProviderActivity extends Activity implements View.OnClickListener {

    private Button insert;
    private Button update;
    private Button delete;
    private Button query;


    String newId = "4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_my_provider_activity);
        insert = (Button) findViewById(R.id.insert);
        insert.setOnClickListener(this);
        update = (Button) findViewById(R.id.update);
        update.setOnClickListener(this);
        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(this);
        query = (Button) findViewById(R.id.select);
        query.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Uri uri = null;
        ContentValues values = null;
        switch (v.getId()) {
            case R.id.insert:
                uri = Uri.parse("content://com.yong.job.provider/book");
                values = new ContentValues();
                values.put("name", "thinking in java");
                values.put("author", "eke");
                values.put("price", 52.3);
                Uri newUri = getContentResolver().insert(uri, values);
                newId = newUri.getPathSegments().get(1);
                Toast.makeText(MyProviderActivity.this, "INSERT successful,new ID :" + newId, Toast.LENGTH_LONG).show();
                break;
            case R.id.update:
                uri = Uri.parse("content://com.yong.job.provider/book/" + newId);
                values = new ContentValues();
                values.put("price", 100);
                int row = getContentResolver().update(uri, values, null, null);
                Toast.makeText(MyProviderActivity.this, "UPDATE successful,change row :" + row, Toast.LENGTH_LONG)
                        .show();
                break;
            case R.id.delete:
                uri = Uri.parse("content://com.yong.job.provider/book/" + newId);
                int delRow = getContentResolver().delete(uri, null, null);
                Toast.makeText(MyProviderActivity.this, "DELETE successful,change row :" + delRow, Toast.LENGTH_LONG)
                        .show();
                break;
            case R.id.select:
                uri = Uri.parse("content://com.yong.job.provider/book");
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                while (cursor.moveToNext()) {
                    Log.e("id", cursor.getInt(cursor.getColumnIndex("id")) + "");
                    Log.e("name", cursor.getString(cursor.getColumnIndex("name")));
                    Log.e("author", cursor.getString(cursor.getColumnIndex("author")));
                    Log.e("price", cursor.getFloat(cursor.getColumnIndex("price")) + "");
                }
                break;
            default:
                break;
        }
    }
}
