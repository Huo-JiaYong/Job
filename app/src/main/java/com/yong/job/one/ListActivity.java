package com.yong.job.one;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yong.job.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends Activity {

    private ListView simpleList;
    private ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_list_activity);
        simpleList = (ListView) findViewById(R.id.simpleList);
        myList = (ListView) findViewById(R.id.myList);

        String[] data = {"apple", "banana", "orange", "cherry"};
        List<Book> list = new ArrayList<>();
        list.add(new Book(R.drawable.blue, "Android开发艺术", "就说我"));
        list.add(new Book(R.drawable.brown, "第一行代码", "郭霖"));
        list.add(new Book(R.drawable.gray, "Thinking in java", "AI可"));
        list.add(new Book(R.drawable.green, "吾从未见过如此厚颜无耻", "诸葛孔明"));
        list.add(new Book(R.drawable.blue, "Android开发艺术", "就说我"));
        list.add(new Book(R.drawable.brown, "第一行代码", "郭霖"));
        list.add(new Book(R.drawable.gray, "Thinking in java", "AI可"));
        list.add(new Book(R.drawable.green, "吾从未见过如此厚颜无耻", "诸葛孔明"));
        list.add(new Book(R.drawable.blue, "Android开发艺术", "就说我"));
        list.add(new Book(R.drawable.brown, "第一行代码", "郭霖"));
        list.add(new Book(R.drawable.gray, "Thinking in java", "AI可"));
        list.add(new Book(R.drawable.green, "吾从未见过如此厚颜无耻", "诸葛孔明"));
        list.add(new Book(R.drawable.blue, "Android开发艺术", "就说我"));
        list.add(new Book(R.drawable.brown, "第一行代码", "郭霖"));
        list.add(new Book(R.drawable.gray, "Thinking in java", "AI可"));
        list.add(new Book(R.drawable.green, "吾从未见过如此厚颜无耻", "诸葛孔明"));
        simpleList.setAdapter(new ArrayAdapter<String>(ListActivity.this, android.R.layout.simple_list_item_1, data));
        myList.setAdapter(new BookAdapter(this, R.layout.one_student_item, list));
    }
}
