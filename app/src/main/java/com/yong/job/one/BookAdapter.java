package com.yong.job.one;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yong.job.R;

import java.util.List;

/**
 * Created by jyong on 2016/3/18.
 */
public class BookAdapter extends ArrayAdapter<Book> {

    private int resourceId;

    public BookAdapter(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }


    @Override
    public Book getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book book = getItem(position);
        View view;
        ViewHolder holder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.one_student_item, null);
            holder = new ViewHolder();
            holder.image = (ImageView) view.findViewById(R.id.head);
            holder.title = (TextView) view.findViewById(R.id.title);
            holder.spec = (TextView) view.findViewById(R.id.spec);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (ViewHolder) convertView.getTag();
        }
        holder.image.setImageResource(book.getImage());
        holder.title.setText(book.getTitle());
        holder.spec.setText(book.getAuthor());

        return view;
    }

    class ViewHolder {
        ImageView image;
        TextView title;
        TextView spec;
    }
}
