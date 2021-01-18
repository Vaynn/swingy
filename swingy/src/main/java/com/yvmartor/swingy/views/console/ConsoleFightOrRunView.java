package com.yvmartor.swingy.views.console;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;
import com.yvmartor.swingy.models.scenario.question.Question;
import com.yvmartor.swingy.models.villains.Villain;

import java.util.ArrayList;

public class ConsoleFightOrRunView {

    public void printFightOrRun(Hero hero, Villain villain, Question question){
        ConsoleStringColor.story(question.getQuestion() + "\n");
        ArrayList<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++){
            ConsoleStringColor.action("\t" + (i + 1) + ") " + options.get(i) + "\n" );
        }

    }
}
