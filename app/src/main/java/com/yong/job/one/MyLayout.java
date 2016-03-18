package com.yong.job.one;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.yong.job.R;

/**
 * Created by jyong on 2016/3/18.
 */
public class MyLayout extends RelativeLayout {

    private Button custom;

    public MyLayout(final Context context, AttributeSet attr) {
        super(context, attr);
        LayoutInflater.from(context).inflate(R.layout.one_other_activity, this);
        custom = (Button) findViewById(R.id.custom);
        custom.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Hello world", Toast.LENGTH_LONG).show();
            }
        });
    }


}
