package com.yong.job.three;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.yong.job.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileActivity extends Activity {

    private EditText write;
    private Button btnWrite;
    private TextView read;
    private Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_file_activity);

        write = (EditText) findViewById(R.id.write);
        btnWrite = (Button) findViewById(R.id.btn_write);
        read = (TextView) findViewById(R.id.read);
        btnRead = (Button) findViewById(R.id.btn_read);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = write.getText().toString();

                try {
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(openFileOutput("data",
                            MODE_PRIVATE)));
                    writer.write(data);
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("data")));
                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);
                    }
                    reader.close();

                    read.setText(builder);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
