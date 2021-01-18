package com.yvmartor.swingy.models.scenario.question;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

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

    @Range(min = MIN_RANGE, max = MAX_RANGE, message = "Error: you must choose between " + MIN_RANGE + "and " + MAX_RANGE + ".\n")
    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
}
