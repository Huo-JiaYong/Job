package com.yong.job.two.news;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yong.job.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsContentFragment extends Fragment {

    private View view;

    public NewsContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.news_content_fragment, container, false);
        return view;
    }

    public  void refresh(String title, String content){
        ((LinearLayout)view.findViewById(R.id.visibility_layout)).setVisibility(View.VISIBLE);
        ((TextView)view.findViewById(R.id.content_title)).setText(title);
        ((TextView)view.findViewById(R.id.content_content)).setText(content);
    }


}
