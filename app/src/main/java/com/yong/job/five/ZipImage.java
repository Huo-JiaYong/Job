package com.yong.job.five;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by jyong on 2016/4/3.
 */
public class ZipImage {

    public static Bitmap zip(Resources res, int resId, int reqWidth, int reqHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = caluSimpleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int caluSimpleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int width = options.outWidth;
        final int height = options.outHeight;

        int inSimpleSize = 1;

        if (width > reqWidth || height > reqHeight) {
            final int widthRetaio = Math.round((float) width / (float) reqHeight);
            final int heightRetaio = Math.round((float) height / (float) reqHeight);

            inSimpleSize = widthRetaio < heightRetaio ? widthRetaio : heightRetaio;
        }

        return inSimpleSize;
    }
}
