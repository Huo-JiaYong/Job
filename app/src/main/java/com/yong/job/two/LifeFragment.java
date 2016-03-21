package com.yong.job.two;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yong.job.R;

/**
 * Created by jyong on 2016/3/18.
 */
public class LifeFragment extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        Log.e("Fragment—onAttach", "Fragment与Activity产生关联");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e("Fragment—onCreate ", "Fragment被创建");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_top_fragment,container,false);
        Log.e("Fragment—onCreateView ", "Fragment UI被创建");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.e("Fragment—onActivity ", "Activity被创建完后");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.e("Fragment—onStart ", "Fragment在屏幕可见位置");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e("Fragment—onResume ", "Fragment在第一交互位");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("Fragment—onPause ", "Fragment被不完全遮挡");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e("Fragment—onStop ", "Fragment被完全遮挡");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e("Fragment—onDestroyView ", "Fragment UI被销毁");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("Fragment—onDestroy ", "Fragment被销毁");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e("Fragment—onDetach ", "Fragment与Activity取消关联");
        super.onDetach();
    }
}
