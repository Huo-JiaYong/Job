package com.yong.job.five;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.yong.job.R;

public class ZipImageActivity extends Activity implements View.OnClickListener {

    private Button nozip;
    private Button zip;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_zip_image_activity);
        nozip = (Button) findViewById(R.id.nozip);
        nozip.setOnClickListener(this);
        zip = (Button) findViewById(R.id.zip);
        zip.setOnClickListener(this);
        image = (ImageView) findViewById(R.id.image);

        Log.e("MEMORY", Runtime.getRuntime().maxMemory() / 1024 / 1024 + "mb");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nozip:
                image.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.lol));
                break;
            case R.id.zip:
                image.setImageBitmap(ZipImage.zip(getResources(), R.drawable.lol, 500, 500));
                break;
        }
    }

    public void loadLru() {
        //how want to use LurCache
        //cache size  = memory / 8 (kb)
        int maxSize = (int) (Runtime.getRuntime().maxMemory() / 1024 / 8);
        LruCache<String, Bitmap> cache = new LruCache<String,Bitmap>(maxSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount() / 1024;
            }
        };

        //input cache
        cache.put("key",BitmapFactory.decodeResource(getResources(),R.drawable.lol));

        //get cache
        Bitmap map = cache.get("key");
    }


}
