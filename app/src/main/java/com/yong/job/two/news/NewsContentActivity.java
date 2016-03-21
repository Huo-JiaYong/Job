package com.yong.job.two.news;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.yong.job.R;

public class NewsContentActivity extends Activity {

    public static void actionStart(Context context, String title, String content) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("content", content);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content_activity);
        //当这个Activity被创建的时候 证明使用的是普通模式，需要重新加载content的数据
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");

        NewsContentFragment contentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id
                .content_fragment);
        contentFragment.refresh(title, content);
    }
}
