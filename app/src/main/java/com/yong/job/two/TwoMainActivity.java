package com.yong.job.two;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yong.job.R;

public class TwoMainActivity extends Activity {

    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_main_activity);
        add = (Button) findViewById(R.id.addFragment);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.botLayout, new TopFragment()).addToBackStack
                        (null).commit();
            }
        });
    }

}
