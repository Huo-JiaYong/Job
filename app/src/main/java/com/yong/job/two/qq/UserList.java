package com.yong.job.two.qq;

import java.util.ArrayList;

/**
 * Created by jyong on 2016/3/21.
 */
public class UserList extends ArrayList<User> {

    public User getUserByName(String name){
        User user = new User(0,"0","0");
        for (User item: this){
            if (item.getName().equals(name)){
                return item;
            }
        }
        return user;
    }
}
