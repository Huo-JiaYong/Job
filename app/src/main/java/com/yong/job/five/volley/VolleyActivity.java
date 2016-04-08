package com.yong.job.five.volley;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.yong.job.R;

import org.json.JSONObject;

public class VolleyActivity extends Activity implements View.OnClickListener {

    private Button string;
    private Button json;
    private Button image;
    private Button loader;
    private Button gson;

    private ImageView imageView;

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_volley_activity);
        string = (Button) findViewById(R.id.string);
        string.setOnClickListener(this);
        json = (Button) findViewById(R.id.json);
        json.setOnClickListener(this);
        image = (Button) findViewById(R.id.image);
        image.setOnClickListener(this);
        loader = (Button) findViewById(R.id.imageLoader);
        loader.setOnClickListener(this);
        gson = (Button) findViewById(R.id.gson);
        gson.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.imageView);

        queue = Volley.newRequestQueue(this);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.string:
                //Request.Method.POST
                //new StringRequest(){
                //  @Override
                //  protected Map<String, String> getParams() throws AuthFailureError {
                //      Map<String, String> map = new HashMap<String, String>();
                //      map.put("params1", "value1");
                //      return map;
                //  }
                StringRequest stringRequest = new StringRequest("http://www.baidu.com",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String s) {
                                Log.e("string", s);
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Log.e("error", volleyError.getMessage());
                            }
                        });

                queue.add(stringRequest);
                break;
            case R.id.json:
                JsonObjectRequest jsonRequest = new JsonObjectRequest("http://m.weather.com.cn/data/101010100.html",
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                Log.e("json", jsonObject.toString());
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Log.e("error", volleyError.getMessage());
                            }
                        });

                queue.add(jsonRequest);
                break;
            case R.id.image:
                ImageRequest imageRequest = new ImageRequest("http://img.my.csdn" +
                        ".net/uploads/201404/13/1397393290_5765.jpeg",
                        new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap bitmap) {
                                imageView.setImageBitmap(bitmap);
                            }

                        },
                        0, 0, Bitmap.Config.RGB_565,
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Log.e("error", volleyError.getMessage());
                            }
                        }
                );

                queue.add(imageRequest);
                break;
            case R.id.imageLoader:
                ImageLoader loader = new ImageLoader(queue, new BitmapCache());
                ImageLoader.ImageListener listener = ImageLoader.getImageListener(imageView, R.drawable.head, R
                        .drawable.bg);
                loader.get("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg", listener);
                break;
            case R.id.gson:
                GsonRequest<Start> gsonRequest = new GsonRequest<Start>(
                        "http://news-at.zhihu.com/api/4/start-image/1080*1776",
                        Start.class,
                        new Response.Listener<Start>() {
                            @Override
                            public void onResponse(Start start) {
                                Log.e("text", start.getText());
                                Log.e("img", start.getImg());
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {
                                Log.e("error", volleyError.getMessage());
                            }
                        }
                );

                queue.add(gsonRequest);
                break;
        }
    }
}
