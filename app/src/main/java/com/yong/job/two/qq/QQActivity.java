package com.yong.job.two.qq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yong.job.R;

public class QQActivity extends Activity {

    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_qq_activity);
        send = (Button) findViewById(R.id.sendBroadcast);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send broadcast
                Intent intent = new Intent("com.yong.job.OFF_LINE");
                sendBroadcast(intent);
            }
        });
    }
}
