package com.zybooks.thewatchfuleye;

public class Article {
    private String mTitle;
    private String mDescription;

    public Article() {}

    public Article(String title, String description) {
        mTitle = title;
        mDescription = description;
    }

    public String getTitle() {
        return mTitle;
    }
    public String getDescription() {
        return mDescription;
    }
    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

}
