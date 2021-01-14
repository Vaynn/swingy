package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.adventure.Adventure;
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
        consoleView.printGameAdventure(hero, model.getOptions());
        scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        WorldMap worldMap = model.getWorldMap();
        worldMap.updateHeroCoordinates(choice);
        System.out.println(hero.getCoordinates().getX());
        System.out.print(hero.getCoordinates().getY());
    }

}
