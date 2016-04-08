package com.yong.job.five.jackson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yong.job.R;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JacksonActivity extends Activity implements View.OnClickListener {

    private Button toJson;
    private Button toBean;

    private String jsonString;


    //model
    private Image model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_jackson_activity);
        toJson = (Button) findViewById(R.id.toJson);
        toJson.setOnClickListener(this);
        toBean = (Button) findViewById(R.id.toBean);
        toBean.setOnClickListener(this);
        model = new Image();
        model.setText("© 霍加勇");
        model.setImg("http://qq.kongjian.com/8992374/19273.jpg");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toJson:
                ObjectMapper mapper = new ObjectMapper();
                try {
                    jsonString = mapper.writeValueAsString(model);
                    Log.e("JSON", jsonString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.toBean:
                mapper = new ObjectMapper();
                try {
                    model = mapper.readValue(jsonString, Image.class);
                    Log.e("text", model.getText());
                    Log.e("img", model.getImg());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}