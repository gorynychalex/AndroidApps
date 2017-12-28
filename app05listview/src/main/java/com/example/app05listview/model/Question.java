package com.example.app05listview.model;

import java.util.List;

/**
 * Created by user on 26.12.2017.
 */

public class Question {

    private int id;
    private String text;
    private List<Option> options;
    private String pictureUrl;

    public Question(String text, List<Option> options) {
        this.text = text;
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
