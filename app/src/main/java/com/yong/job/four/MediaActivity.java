package com.yong.job.four;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.yong.job.R;

import java.io.File;
import java.io.IOException;

public class MediaActivity extends Activity implements View.OnClickListener {

    private Button musicPlay;
    private Button musicPause;
    private Button videoPlay;
    private Button videoPause;

    private MediaPlayer player;

    private VideoView vv_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_media_activity);
        musicPlay = (Button) findViewById(R.id.musicPlay);
        musicPlay.setOnClickListener(this);
        musicPause = (Button) findViewById(R.id.musicPause);
        musicPause.setOnClickListener(this);
        videoPlay = (Button) findViewById(R.id.videoPlay);
        videoPlay.setOnClickListener(this);
        videoPause = (Button) findViewById(R.id.videoPause);
        videoPause.setOnClickListener(this);

        vv_video = (VideoView) findViewById(R.id.vv_video);

        player = new MediaPlayer();
        try {
            player.setDataSource(this, Uri.fromFile(new File("/mnt/sdcard/Music/Download/DNCE - Swaay/Cake by the " +
                    "Ocean.mp3")));
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        vv_video.setVideoPath(Environment.getExternalStorageDirectory() + "/DCIM/Video/V50623-144548.MP4");

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.musicPlay:
                player.start();
                break;
            case R.id.musicPause:
                player.pause();
                break;
            case R.id.videoPlay:
                vv_video.start();
                break;
            case R.id.videoPause:
                vv_video.pause();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vv_video.suspend();
    }
}
