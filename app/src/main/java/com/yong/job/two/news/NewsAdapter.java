package com.yong.job.two.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yong.job.R;

import java.util.List;

/**
 * Created by jyong on 2016/3/18.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    private int resourceId;

    public NewsAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public News getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            holder = new ViewHolder();
            holder.title = (TextView) view.findViewById(R.id.news_title);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }

        holder.title.setText(news.getTitle());

        return view;
    }

    class ViewHolder{
        TextView title;
    }
}
