package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.VillainDirector;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.models.villains.VillainBuilder;
import com.yvmartor.swingy.models.villains.EvilCatBuilder;
import com.yvmartor.swingy.models.villains.MickachuBuilder;
import com.yvmartor.swingy.models.villains.BadassMickey;
import com.yvmartor.swingy.models.scenario.adventure.Adventure;
import com.yvmartor.swingy.models.scenario.adventure.AdventureBuilder;
import com.yvmartor.swingy.models.scenario.select_hero.SelectHero;
import com.yvmartor.swingy.views.console.ConsoleAdventureView;
import com.yvmartor.swingy.views.console.ConsoleSelectHeroView;
import com.yvmartor.swingy.views.gui.GUISelectHeroView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class SelectHeroController {
    private SelectHero model;
    private ConsoleSelectHeroView consoleView;
    private GUISelectHeroView gUIView;
    private Scanner userChoice;
    private int choice;
    private JFrame frame;
    private VillainBuilder[] vilainTab = {
            new EvilCatBuilder(), new MickachuBuilder(), new BadassMickey()
    };

    public SelectHeroController(SelectHero model, JFrame frame, ConsoleSelectHeroView consoleView, GUISelectHeroView gUIView){
        this.model = model;
        this.consoleView = consoleView;
        this.gUIView = gUIView;
        this.frame = frame;
    }

    public void updateConsoleView(){
        consoleView.printSelectHeroView(model.getTitle(), model.getHeroesList());
        userChoice = new Scanner(System.in);
        choice = userChoice.nextInt();

        //create map, register the hero on it and place him on the center of the map
        WorldMap worldmap = new WorldMap();
        Hero hero = model.getHeroesList().get(choice - 1);
        hero.registerWorldMap(worldmap);

        //register vilains on the map , I decide to give 40% of the map to the vilains
        //vilains are randomly chosen between 3 classes of different strenght
        int totalVilains = worldmap.vilainProportionCalculator();
        VillainDirector director = new VillainDirector();
        Random rand = new Random();
        for (int i = 0; i < totalVilains; i++){
            int randy = rand.nextInt(3);
            director.setVilainBuilder(vilainTab[randy]);
            director.constructVilain(hero);
            Villain villain = director.getVilain();
            villain.setIdx(i);
            villain.registerWorldMap(worldmap);
        }

        String[] options = {
                "Go to the north.",
                "Go to the east.",
                "Go to the south.",
                "Go to the west."
        };
        Adventure model = new AdventureBuilder().hero(hero).options(options).worldMap(worldmap).build();
        ConsoleAdventureView view = new ConsoleAdventureView();
        AdventureController controller = new AdventureController(model, view);
        controller.updateConsoleView();

    }

    public void updateGUIView() throws IOException {
        gUIView.printSelectHeroView(frame, model.getTitle(), model.getHeroesList());
        gUIView.getSelection().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int heroIdx = gUIView.getHeroTab().getSelectedIndex();

            }
        });
    }
}
