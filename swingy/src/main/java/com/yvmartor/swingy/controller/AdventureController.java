package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.adventure.Adventure;
import com.yvmartor.swingy.models.vilains.Vilain;
import com.yvmartor.swingy.views.console.ConsoleAdventureView;

import java.util.Scanner;

public class AdventureController {
    private Adventure model;
    private ConsoleAdventureView consoleView;
    private Scanner scanner;
    private int choice;

    public AdventureController(Adventure model, ConsoleAdventureView consoleView){
        this.model = model;
        this.consoleView = consoleView;
    }

    public void updateConsoleView(){
        Hero hero = model.getHero();
        WorldMap worldMap = model.getWorldMap();

        while (true) {
            consoleView.printGameAdventure(hero, model.getOptions());
            scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            worldMap.updateHeroCoordinates(choice);
            Vilain enemy = worldMap.isHeroMeetVilain();
            if (enemy != null)
                System.out.println(enemy.getName());
        }
    }

}
