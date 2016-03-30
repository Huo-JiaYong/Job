package com.yong.job.three;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yong.job.R;

import java.util.ArrayList;
import java.util.List;

public class PhoneProviderActivity extends Activity {

    private ListView lv_phone;
    private List<String> phones;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_phone_provider_activity);
        lv_phone = (ListView) findViewById(R.id.lv_phone);

        phones = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, phones);

        //获取Phone所提供的内容
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,
                null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone
                        .DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                phones.add(name + "\n" + number);
            } while (cursor.moveToNext());
        }

        lv_phone.setAdapter(adapter);
    }
}
