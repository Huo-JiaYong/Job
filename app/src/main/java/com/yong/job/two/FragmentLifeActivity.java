package com.yong.job.two;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.yong.job.R;

public class FragmentLifeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_life_activity);
        Log.e("onCreate","Activity创建");
    }

    @Override
    protected void onStart() {
        Log.e("onStart", "Activity在屏幕可见位置");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e("onResume", "Activity在第一交互位");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e("onPause", "Activity被不完全遮挡");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("onStop", "Activity被完全遮挡");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.e("onRestart","Activity重新回到第一交互位");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.e("onDestroy", "Activity被销毁");
        super.onDestroy();
    }
}
