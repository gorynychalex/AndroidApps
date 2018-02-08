package com.samsung.itschool.app11retrofit.model;

import java.util.Date;
import java.util.List;

public class Question {
    private int id;
    private String text;
    private List<Option> options;
    private Date startTime;
    private Date stopTime;
    private byte result=0;

    public Question(){}

    public Question(int id, String text, List<Option> options) {
        this.id=id;
        this.text = text;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public byte getResult() {

        //mark = КВП/ОКП/(КВН + 1)
        int sumOptionsTrue=0,sumAnsTrue=0,sunAnsFalse=0;
        for(int i = 0; i < options.size(); i++) {
            if(options.get(i).isCorrect()) sumOptionsTrue++;
            if(options.get(i).isCorrect() & options.get(i).isUserAnswer()) sumAnsTrue++;
            if( (options.get(i).isCorrect() ^ options.get(i).isUserAnswer()) & !options.get(i).isUserAnswer()) {sunAnsFalse++; }
        }

        float markFloat = (float)sumAnsTrue/(float)sumOptionsTrue/((float)sunAnsFalse+1);
        result = (byte) (markFloat*100);

        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }
}
