package com.yong.job.four;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.yong.job.R;

import java.io.File;
import java.io.FileNotFoundException;

public class CameraActivity extends Activity implements View.OnClickListener {

    private Button open;
    private ImageView iv_photo;
    private Button crop;
    private Button show;
    private Uri uri = Uri.fromFile(new File("/mnt/sdcard/photo.jpg"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four_camera_activity);
        open = (Button) findViewById(R.id.openCamera);
        open.setOnClickListener(this);
        crop = (Button) findViewById(R.id.crop);
        crop.setOnClickListener(this);
        show = (Button) findViewById(R.id.show);
        show.setOnClickListener(this);
        iv_photo = (ImageView) findViewById(R.id.photo);

        //get photo
        Bitmap photo = null;
        try {
            photo = BitmapFactory.decodeStream(this.getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (photo != null) {
            iv_photo.setImageBitmap(photo);
        }
        Toast.makeText(this, "" + (photo == null), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.openCamera:
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivity(intent);
                break;
            case R.id.crop:
                Intent intent1 = new Intent("com.android.camera.action.CROP");
                intent1.setDataAndType(uri, "image/*");
                intent1.putExtra("scale", true);
                intent1.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivity(intent1);
                break;
            case R.id.show:
                Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
                intent2.setType("image/*");
                intent2.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }
}
