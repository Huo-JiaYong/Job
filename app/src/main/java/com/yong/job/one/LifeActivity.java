package com.yong.job.one;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yong.job.R;

public class LifeActivity extends Activity {

    private Button showDialog;
    private Button showActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_life_activity);
        Log.e("onCreate", "Activity被创建的时候");
        showDialog = (Button) findViewById(R.id.showDialog);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(LifeActivity.this);
                dialog.setTitle("show");
                dialog.setMessage("some thing");
                dialog.show();
            }
        });

        showActivity = (Button) findViewById(R.id.showActivity);
        showActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeActivity.this,OtherActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("OnStart", "Activity处于可见位置");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("OnResume", "Activity处于焦点位置(即用户屏幕显示的第一位置)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "Activity被不完全遮挡");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "Activity被完全遮挡");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestory", "Activity被关闭");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart","Activity被重新启动");
    }
}
