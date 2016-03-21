package com.yong.job.two;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yong.job.R;

/**
 * Created by jyong on 2016/3/18.
 */
public class BotFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_bot_fragment, container, false);
        return view;
    }
}
