package com.yvmartor.swingy.views.console;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;

import java.util.ArrayList;

public class ConsoleSelectHeroView {
    public void printSelectHeroView(String title, ArrayList<Hero> heroesList){
        ConsoleStringColor.story(title);
        for (int i = 0; i < heroesList.size(); i++){
            Hero hero = heroesList.get(i);
            int id = i + 1;
            ConsoleStringColor.hero(id + ") " + hero.getName() + "\n");
            ConsoleStringColor.hero("\t" + "Classe : " + hero.getHeroClass());
            ConsoleStringColor.hero("\t" + "Level : " + hero.getLevel());
            ConsoleStringColor.hero("\t" + "XP : " + hero.getXp());
            ConsoleStringColor.hero("\t" + "Attak : " + hero.getAttak());
            ConsoleStringColor.hero("\t" + "Defense : " + hero.getDefense());
            ConsoleStringColor.hero("\t" + "HP : " + hero.getHitPoints() + "\n");
        }
    }
}
