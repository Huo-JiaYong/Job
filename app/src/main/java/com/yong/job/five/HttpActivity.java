package com.yong.job.five;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yong.job.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpActivity extends Activity implements View.OnClickListener {

    private Button btnUrl;
    private Button btnClient;
    private TextView text;

    private static final int UPDATE_TEXT = 1;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    String allText = (String) msg.obj;
                    text.setText(allText);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_http_activity);
        btnClient = (Button) findViewById(R.id.client);
        btnClient.setOnClickListener(this);
        btnUrl = (Button) findViewById(R.id.url);
        btnUrl.setOnClickListener(this);
        text = (TextView) findViewById(R.id.text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.url:
                sendUrl();
                break;
            case R.id.client:
                sendClient();
                break;
        }
    }

    public void sendUrl() {
        new Thread(new Runnable() {
            HttpURLConnection connection;

            @Override
            public void run() {
                try {
                    connection = (HttpURLConnection) (new URL("http://www.baidu.com"))
                            .openConnection();
                    connection.setRequestMethod("GET");
                    //set params
                    //new DataOutputStream(connection.getOutputStream()).writeBytes("user=123&pwd=123");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line = "";
                    String all = "";
                    while ((line = reader.readLine()) != null) {
                        all += line;
                    }
                    Message message = new Message();
                    message.what = UPDATE_TEXT;
                    message.obj = all;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    public void sendClient() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpClient client = new DefaultHttpClient();
                HttpGet get = new HttpGet("http://www.baidu.com");
                //set params
                //List<BasicNameValue> list =  new ArrayList<BasicNameValue>();
                //list.add(new BasicNameValuePair("key","value"));
                //post.setEntity(new UrlEncodeFromEntity(list,"utf-8));
                try {
                    HttpResponse response = client.execute(get);
                    Message message = new Message();
                    message.what = UPDATE_TEXT;
                    message.obj = response.getStatusLine().getStatusCode() + "";
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}