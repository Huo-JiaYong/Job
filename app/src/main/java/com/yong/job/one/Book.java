package com.yong.job.one;

/**
 * Created by jyong on 2016/3/18.
 */
public class Book {
    private int image;
    private String title;
    private String author;

    public Book(int image, String title, String author) {
        this.image = image;
        this.title = title;
        this.author = author;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
