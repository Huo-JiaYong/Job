package com.yong.job.four;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;

import com.yong.job.R;

/**
 * Created by jyong on 2016/4/1.
 */
public class FrontService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Notification notification = new NotificationCompat.Builder(FrontService.this)
                .setSmallIcon(R.drawable.blue)
                .setTicker("网易云音乐正在播放")
                .setContentTitle("歌名")
                .setContentText("epname")
                .build();
        notification.bigContentView = new RemoteViews(getPackageName(), R.layout.four_remote_notification);
        startForeground(1, notification);
    }
}
