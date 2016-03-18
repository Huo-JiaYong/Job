package com.yong.job.one;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.yong.job.R;

import java.util.ArrayList;

public class OtherActivity extends Activity {

    private TextView other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_other_activity);
        other = (TextView) findViewById(R.id.other);
        //get data for FirstActivity
        ArrayList<Student> data = getIntent().getParcelableArrayListExtra("student");
        if (data != null) {
            String stuString = data.get(0).getName() + data.get(0).getAge() + data.get(0).isSex();
            other.setText(stuString);
        }

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("age", 12);
        setResult(RESULT_OK, intent);
        finish();
    }
}
