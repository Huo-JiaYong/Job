package com.yong.job.one;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yong.job.R;

import java.util.ArrayList;

public class FirstActivity extends Activity implements View.OnClickListener {


    private Button start;
    private Button explicit;
    private Button implicit;
    private Button sendData;
    private Button getData;
    private Button life;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_first_activity_);
        start = (Button) findViewById(R.id.startActivity);
        start.setOnClickListener(this);
        explicit = (Button) findViewById(R.id.explicit);
        explicit.setOnClickListener(this);
        implicit = (Button) findViewById(R.id.implicit);
        implicit.setOnClickListener(this);
        sendData = (Button) findViewById(R.id.sendData);
        sendData.setOnClickListener(this);
        getData = (Button) findViewById(R.id.getData);
        getData.setOnClickListener(this);
        life = (Button) findViewById(R.id.life);
        life.setOnClickListener(this);

        //get saveInstanceState
        if (savedInstanceState != null && savedInstanceState.getString("name") != null) {
            Toast.makeText(FirstActivity.this, savedInstanceState.getString("name"), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.startActivity:
                //start other activity
                intent = new Intent(FirstActivity.this, OtherActivity.class);
                startActivity(intent);
                break;
            case R.id.explicit:
                //explicit start activity
                intent = new Intent(FirstActivity.this, OtherActivity.class);
                startActivity(intent);
                break;
            case R.id.implicit:
                //implicit start activity
                //1 - in manifest.xml config intent-filter -> action:name
                //2 - new Intent("action:name");
                intent = new Intent("com.yong.job.one.IMPLICIT");
                startActivity(intent);
                break;
            case R.id.sendData:
                //send data to OtherActivity
                intent = new Intent(FirstActivity.this, OtherActivity.class);
                //intent.putExtra("name", "tom");
                //send Student
                ArrayList<Student> students = new ArrayList<>();
                students.add(new Student("tom", 11, true));
                intent.putParcelableArrayListExtra("student", students);
                startActivity(intent);
                break;
            case R.id.getData:
                //get data for OtherActivity
                intent = new Intent(FirstActivity.this, OtherActivity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.life:
                //show Activity Life
                intent = new Intent(FirstActivity.this, LifeActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    Log.e("AGE", data.getIntExtra("age", 10) + "");
                }
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name", "jack");
    }
}
