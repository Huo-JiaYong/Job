package com.yong.job.four;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yong.job.R;

public class ServiceActivity extends Activity implements View.OnClickListener {

    private Button start;
    private Button stop;
    private Button bind;
    private Button unbind;
    private Button front;

    private MyService.MyBinder binder;
    private ServiceConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_service_activity);
        start = (Button) findViewById(R.id.startService);
        start.setOnClickListener(this);
        stop = (Button) findViewById(R.id.stopService);
        stop.setOnClickListener(this);
        bind = (Button) findViewById(R.id.bind);
        bind.setOnClickListener(this);
        unbind = (Button) findViewById(R.id.unbind);
        unbind.setOnClickListener(this);
        front = (Button) findViewById(R.id.front);
        front.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.startService:
                Log.e("demo", "hello");
                intent = new Intent(ServiceActivity.this, MyService.class);
                startService(intent);
                break;
            case R.id.stopService:
                intent = new Intent(ServiceActivity.this, MyService.class);
                stopService(intent);
                break;
            case R.id.bind:
                connection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        binder = (MyService.MyBinder) service;
                        ((MyService) binder.getService()).setName("tom");
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {

                    }
                };
                intent = new Intent(ServiceActivity.this, MyService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(connection);
                break;
            case R.id.front:
                intent = new Intent(ServiceActivity.this, FrontService.class);
                startService(intent);
                break;
        }
    }
}
