package com.yvmartor.swingy.models.scenario.question;

import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> options;
    private int response;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 2;


    public Question(String question, ArrayList<String> options){
        this.question = question;
        this.options = options;

    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
}
