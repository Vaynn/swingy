package com.yvmartor.swingy.views.console;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;

import java.util.ArrayList;

public class ConsoleAdventureView {

    public void printGameAdventure(Hero hero, String[] options){
        ConsoleStringColor.story(hero.getName() + " walks through the labyrinth.\n");
        ConsoleStringColor.story("What do you want to do ?\n");
        for (int i = 0; i < options.length; i++) {
            int indice = i + 1;
            ConsoleStringColor.action("\t" + indice + ") " + options[i] + "\n");
        }
        System.out.println("\n");

    }
}
