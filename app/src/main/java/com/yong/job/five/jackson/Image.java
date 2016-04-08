package com.yong.job.five.jackson;

/**
 * Created by jyong on 2016/4/6.
 */
public class Image {
    /**
     * text : © 许英龙
     * img : https://pic3.zhimg.com/2d16f25c61e0323babf2f8ff5eb94d9f.jpg
     */

    private String text;
    private String img;


    public void setText(String text) {
        this.text = text;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public String getImg() {
        return img;
    }
}
