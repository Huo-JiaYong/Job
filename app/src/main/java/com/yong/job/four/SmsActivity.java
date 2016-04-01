package com.yong.job.four;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

import com.yong.job.R;

public class SmsActivity extends Activity {

    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_sms_activity);
        send = (Button) findViewById(R.id.sendSMS);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage("15181010990", null, "hello world", null, null);
            }
        });
    }
}
