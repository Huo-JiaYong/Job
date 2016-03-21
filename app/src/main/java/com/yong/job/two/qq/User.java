package com.yong.job.two.qq;

/**
 * Created by jyong on 2016/3/21.
 */
public class User {

    private int image;
    private String name;
    private String pwd;

    public User(int image, String name, String pwd) {
        this.image = image;
        this.name = name;
        this.pwd = pwd;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
