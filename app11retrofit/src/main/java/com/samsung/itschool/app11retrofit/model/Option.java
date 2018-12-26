package com.samsung.itschool.app11retrofit.model;

import com.google.gson.annotations.SerializedName;

public class Option {

    @SerializedName("id")
    private long id;

    @SerializedName("text")
    private String text;

    @SerializedName("correct")
    private boolean correct;

    @SerializedName("user_answer")
    private boolean userAnswer;

    public Option(){}

    public Option(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(boolean userAnswer) {
        this.userAnswer = userAnswer;
    }
}
