package com.yong.job.five.volley;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by jyong on 2016/4/3.
 */
public class BitmapCache implements ImageLoader.ImageCache {

    private LruCache<String, Bitmap> lruCache;

    public BitmapCache() {
        int max = (int) (Runtime.getRuntime().maxMemory() / 1024 / 8);
        lruCache = new LruCache<String, Bitmap>(max) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount() / 1024;
            }
        };
    }

    @Override
    public Bitmap getBitmap(String s) {
        return lruCache.get(s);
    }

    @Override
    public void putBitmap(String s, Bitmap bitmap) {
        lruCache.put(s, bitmap);
    }
}
