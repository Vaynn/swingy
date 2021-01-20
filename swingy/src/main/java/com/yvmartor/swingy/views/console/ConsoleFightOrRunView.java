package com.yvmartor.swingy.views.console;

import com.yvmartor.swingy.models.artefacts.Armor;
import com.yvmartor.swingy.models.artefacts.Artefact;
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

    public void printKeepArtefactAsk(Villain villain, Artefact heroArtefact){
        ConsoleStringColor.story("Well Done! You defeated the " + villain.getName() + "!\n");
        ConsoleStringColor.story(
                "He dropped "
                        + villain.getArtefact().getName()
                        + ". It would increase your "
                        + villain.getArtefact().getIncreasedStat()
                        + " by "
                        +villain.getArtefact().getPoints() +".\n");
        if (heroArtefact.getName().compareTo("None") != 0) {
            ConsoleStringColor.story("For now you are wearing a "
                    + heroArtefact.getName()
                    + "with an increase of "
                    + heroArtefact.getPoints()
                    + ".\n");
        }
        ConsoleStringColor.story("Do you want to wear it ? \n");
        ConsoleStringColor.action("\t1) Yes\n" + "\t2) No\n");

    }

    public void printKeepArtefactChoice(boolean choice) {
        if (choice == true){
            ConsoleStringColor.story("You are now wearing your new artefact. \u2694\n");
        } else {
            ConsoleStringColor.story("You left the artefact.\n");
        }
    }

    public void printWinXP(boolean levelUp, int villainXp, Hero hero) {
        ConsoleStringColor.story("You won " + villainXp + "XP you now have " + (int)hero.getXp() + " XP.\n");
        if (levelUp == true){
            ConsoleStringColor.story("You're level goes up to level " + hero.getLevel() + ". \u2B06\n");
        }
    }
}
