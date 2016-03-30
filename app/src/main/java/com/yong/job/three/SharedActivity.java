package com.yong.job.three;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yong.job.R;

public class SharedActivity extends Activity {

    private EditText write;
    private Button btnWrite;
    private TextView read;
    private Button btnRead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_shared_activity);

        write = (EditText) findViewById(R.id.write);
        btnWrite = (Button) findViewById(R.id.btn_write);
        read = (TextView) findViewById(R.id.read);
        btnRead = (Button) findViewById(R.id.btn_read);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shared = getSharedPreferences("data-shared", MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.putString("name", "tom");
                editor.putInt("age", 11);
                editor.putBoolean("sex", true);
                editor.commit();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences shared = getSharedPreferences("data-shared", MODE_PRIVATE);
                String data = "";
                data = data + shared.getString("name", "jack");
                data = data + shared.getInt("age", 0);
                data = data + shared.getBoolean("sex", false);
                read.setText(data);
            }
        });
    }
}
