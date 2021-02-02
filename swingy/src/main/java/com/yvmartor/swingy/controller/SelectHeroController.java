package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;
import com.yvmartor.swingy.models.villains.VillainDirector;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.models.villains.VillainBuilder;
import com.yvmartor.swingy.models.villains.EvilCatBuilder;
import com.yvmartor.swingy.models.villains.MickachuBuilder;
import com.yvmartor.swingy.models.villains.BadassMickey;
import com.yvmartor.swingy.models.scenario.direction.Direction;
import com.yvmartor.swingy.models.scenario.direction.DirectionBuilder;
import com.yvmartor.swingy.models.scenario.select_hero.SelectHero;
import com.yvmartor.swingy.views.console.ConsoleDirectionView;
import com.yvmartor.swingy.views.console.ConsoleSelectHeroView;
import com.yvmartor.swingy.views.gui.GUIDirectionView;
import com.yvmartor.swingy.views.gui.GUISelectHeroView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

import static com.yvmartor.swingy.models.tools.Tools.DIRECTIONS_TAB;

public class SelectHeroController {

    private SelectHero model;
    private ConsoleSelectHeroView consoleView;
    private GUISelectHeroView gUIView;
    private Scanner userChoice;
    private int choice;
    private JFrame frame;
    private static VillainBuilder[] vilainTab = {
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
        while (!userChoice.hasNext("[1-7]")) {
            ConsoleStringColor.error("You must choice a number between 1-7.");
            userChoice = new Scanner(System.in);
        }
        choice = userChoice.nextInt();
        //create map, register the hero on it and place him on the center of the map
        WorldMap worldmap = new WorldMap();
        Hero hero = model.getHeroesList().get(choice - 1);
        hero.registerWorldMap(worldmap);

        //register vilains on the map , I decide to give 40% of the map to the vilains
        //vilains are randomly chosen between 3 classes of different strenght
        createAndRegisterVillains(worldmap);

        Direction model = new DirectionBuilder().hero(hero).options(DIRECTIONS_TAB).worldMap(worldmap).build();
        ConsoleDirectionView view = new ConsoleDirectionView();
        DirectionController controller = new DirectionController(model, null, view, null);
        controller.updateConsoleView();

    }

    public void updateGUIView() throws IOException {
        gUIView.printSelectHeroView(frame, model.getTitle(), model.getHeroesList());
        gUIView.getSelection().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int heroIdx = gUIView.getHeroTab().getSelectedIndex();
                WorldMap worldMap= new WorldMap();
                Hero hero = model.getHeroesList().get(heroIdx);
                hero.registerWorldMap(worldMap);
                createAndRegisterVillains(worldMap);
                Direction model = new DirectionBuilder().hero(hero).options(DIRECTIONS_TAB).worldMap(worldMap).build();
                GUIDirectionView view = new GUIDirectionView(frame);
                DirectionController controller = new DirectionController(model, frame, null, view);
                controller.updateGUIView();

            }
        });
    }

    public static void createAndRegisterVillains(WorldMap worldmap){
        int totalVilains = worldmap.vilainProportionCalculator();
        VillainDirector director = new VillainDirector();
        Random rand = new Random();
        for (int i = 0; i < totalVilains; i++){
            int randy = rand.nextInt(3);
            director.setVilainBuilder(vilainTab[randy]);
            director.constructVilain(worldmap.getHero());
            Villain villain = director.getVilain();
            villain.setIdx(i);
            villain.registerWorldMap(worldmap);
        }
    }
}
