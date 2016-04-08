package com.yong.job.five.okhttp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yong.job.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpActivity extends Activity {

    private Button string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_ok_http_activity);
        string = (Button) findViewById(R.id.string);
        string.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://http:baidu.com")
                        .build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.e("response", response.body().toString());
                    }
                });

                //post
//                OkHttpClient client1 = new OkHttpClient();
//                RequestBody body = RequestBody.create(MediaType.parse("application/string;charset=utf-8"),"diuleilaomu");
//                Request request1 = new Request.Builder()
//                        .url("http://www.baidu.com")
//                        .post(body)
//                        .build();
//                client1.newCall(request1).enqueue(new Callback() {
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//
//                    }
//
//                    @Override
//                    public void onResponse(Call call, Response response) throws IOException {
//
//                    }
//                });
            }
        });
    }
}
