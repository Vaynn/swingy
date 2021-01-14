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
            ConsoleStringColor.action(id + ") " + hero.getName() + "\n");
            ConsoleStringColor.action("\t" + "Classe : " + hero.getHeroClass());
            ConsoleStringColor.action("\t" + "Level : " + hero.getLevel());
            ConsoleStringColor.action("\t" + "XP : " + hero.getXp());
            ConsoleStringColor.action("\t" + "Attak : " + hero.getAttak());
            ConsoleStringColor.action("\t" + "Defense : " + hero.getDefense());
            ConsoleStringColor.action("\t" + "HP : " + hero.getHitPoints() + "\n");
        }
    }
}
