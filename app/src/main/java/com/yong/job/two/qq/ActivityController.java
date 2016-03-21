package com.yong.job.two.qq;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jyong on 2016/3/21.
 */
public class ActivityController {

    private static List<Activity> list = new ArrayList<>();

    public static void addActivity(Activity activity) {
        list.add(activity);
    }

    public static void removeActivity(Activity activity) {
        list.remove(activity);
    }

    public static void removeAll() {
        for (Activity activity : list) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
