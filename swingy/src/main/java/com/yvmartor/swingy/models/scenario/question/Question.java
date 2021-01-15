package com.yvmartor.swingy.models.scenario.question;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<String> options;
    private int response;

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
    

}
