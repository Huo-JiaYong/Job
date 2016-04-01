package com.yong.job.four;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by jyong on 2016/4/1.
 */
public class MyService extends Service {

    private String name = "";

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("service", "onCreate," + name);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("service", "onBind," + name);
        return new MyBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("service", "onStartCommand," + name);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("service", "onDestroy," + name);
    }

    class MyBinder extends Binder {
        public Service getService() {
            return MyService.this;
        }
    }
}
