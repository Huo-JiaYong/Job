package com.yong.job.four;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.yong.job.R;
import com.yong.job.two.news.NewsTitleActivity;

import java.io.File;

public class NotificationActivity extends Activity implements View.OnClickListener {

    private Button sendNotification;
    private Button big;
    private Button picture;
    private Button inbox;
    private Button progress;
    private Button loop;
    private Button remote;

    private NotificationManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_notification_activity);
        sendNotification = (Button) findViewById(R.id.normal);
        sendNotification.setOnClickListener(this);
        big = (Button) findViewById(R.id.bigStyle);
        big.setOnClickListener(this);
        picture = (Button) findViewById(R.id.pictureStyle);
        picture.setOnClickListener(this);
        inbox = (Button) findViewById(R.id.inboxStyle);
        inbox.setOnClickListener(this);
        progress = (Button) findViewById(R.id.progress);
        progress.setOnClickListener(this);
        loop = (Button) findViewById(R.id.loop);
        loop.setOnClickListener(this);
        remote = (Button) findViewById(R.id.remote);
        remote.setOnClickListener(this);

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    public void onClick(View v) {
        Notification notification = null;
        switch (v.getId()) {
            case R.id.normal:
                Intent intent = new Intent(NotificationActivity.this, NewsTitleActivity.class);
                PendingIntent pi = PendingIntent.getActivity(NotificationActivity.this, 0, intent, PendingIntent
                        .FLAG_CANCEL_CURRENT);
                notification = new Notification.Builder(NotificationActivity.this)
                        .setSmallIcon(R.drawable.blue)
                        .setTicker("扒一扒那些最好色的诗人")
                        .setContentTitle("扒一扒那些最好色的诗人")
                        .setContentText("不是插件p的图，绝对的t1顶级上单，估计波被削完了就到他了，历史的轮回啊。\n" +
                                "几大巨兽和剑姬被削后完全没法和大树比，打泰坦石头什么的完全压制，打猴子塞恩什么的用脚打爆。\n" +
                                "而且有e和被动的存在，被针对了抗压能力也是顶级的。")
                        .setContentIntent(pi)
                        .setSound(Uri.fromFile(new File("/mnt/sdcard/Music/Download/DNCE - Swaay/Cake by the Ocean" +
                                ".mp3")))
                        .setVibrate(new long[]{0, 1000, 2000, 5000})
                        .setLights(Color.BLUE, 2000, 1000)
                        .setAutoCancel(true)
                        .build();
                manager.notify(0, notification);
                break;
            case R.id.bigStyle:
                notification = new Notification.Builder(NotificationActivity.this)
                        .setSmallIcon(R.drawable.blue)
                        .setTicker("扒一扒那些最好色的诗人")
                        .setStyle(new Notification.BigTextStyle()
                                        .setBigContentTitle("扒一扒那些最好色的诗人")
                                        .bigText("不是插件p的图，绝对的t1顶级上单，估计波被削完了就到他了，历史的轮回啊。\n" +
                                                "几大巨兽和剑姬被削后完全没法和大树比，打泰坦石头什么的完全压制，打猴子塞恩什么的用脚打爆。\n" +
                                                "而且有e和被动的存在，被针对了抗压能力也是顶级的。")
                        )
                        .setDefaults(Notification.DEFAULT_ALL)
                        .build();
                manager.notify(1, notification);
                break;
            case R.id.pictureStyle:
                notification = new Notification.Builder(NotificationActivity.this)
                        .setSmallIcon(R.drawable.blue)
                        .setTicker("肾爸爸来了")
                        .setStyle(new Notification.BigPictureStyle()
                                        .setBigContentTitle("知道我是谁么？")
                                        .bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.bg))
                        )
                        .build();
                manager.notify(2, notification);
                break;
            case R.id.inboxStyle:
                notification = new Notification.Builder(NotificationActivity.this)
                        .setSmallIcon(R.drawable.blue)
                        .setTicker("你有新邮件啦")
                        .setStyle(new Notification.InboxStyle()
                                        .setBigContentTitle("you hava 6 message")
                                        .addLine("you are pig")
                                        .addLine("hello")
                                        .addLine("what the fuck,you gone?")
                                        .addLine("china good boy")
                                        .setSummaryText("欢迎来到英雄联盟")
                        )
                        .build();
                manager.notify(3, notification);
                break;
            case R.id.progress:
                final Notification.Builder builder = new Notification.Builder(NotificationActivity.this)
                        .setSmallIcon(R.drawable.blue)
                        .setTicker("正在下载")
                        .setContentTitle("正在下载")
                        .setContentText("苍老师的故事.avi");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 100; i = i + 10) {
                            builder.setProgress(100, i, false);
                            manager.notify(4, builder.build());

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Log.e("demo", "程序搞死了");
                            }
                        }
                        builder.setContentTitle("下载完成")
                                .setProgress(0, 0, false);
                        manager.notify(4, builder.build());
                    }
                }).start();
                break;
            case R.id.loop:
                final Notification.Builder loopBuilder = new Notification.Builder(NotificationActivity.this)
                        .setSmallIcon(R.drawable.blue)
                        .setTicker("正在安装")
                        .setContentTitle("正在安装")
                        .setContentText("苍老师的故事")
                        .setProgress(0, 0, true);
                manager.notify(5, loopBuilder.build());
                break;
            case R.id.remote:
                RemoteViews remoteView = new RemoteViews(getPackageName(), R.layout.four_remote_notification);
                remoteView.setTextViewText(R.id.name, "海阔天空");

                notification = new NotificationCompat.Builder(NotificationActivity.this)
                        .setSmallIcon(R.drawable.gray)
                        .setTicker("网易云音乐正在播放")
                        .setContentTitle("播放")
                        .setContentText("光辉岁月")
                        .build();

                notification.bigContentView = remoteView;
                manager.notify(6, notification);
                break;
        }
    }
}