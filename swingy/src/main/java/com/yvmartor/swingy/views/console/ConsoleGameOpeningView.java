package com.yvmartor.swingy.views.console;

import com.yvmartor.swingy.models.scenario.ConsoleStringColor;

import java.util.ArrayList;

public class ConsoleGameOpeningView {
    public void printGameOpening(String title, ArrayList<String> options){
        ConsoleStringColor.story(title);
        for (int i=0; i < options.size(); i++) {
            System.out.println(options.get(i));
        }
    }
}
