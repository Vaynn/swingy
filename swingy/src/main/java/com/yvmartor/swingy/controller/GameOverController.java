package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;
import com.yvmartor.swingy.models.scenario.direction.Direction;
import com.yvmartor.swingy.models.scenario.direction.DirectionBuilder;
import com.yvmartor.swingy.models.scenario.game_opening.GameOpening;
import com.yvmartor.swingy.models.scenario.game_opening.GameOpeningBuilder;
import com.yvmartor.swingy.models.scenario.game_over.GameOver;
import com.yvmartor.swingy.views.console.ConsoleDirectionView;
import com.yvmartor.swingy.views.console.ConsoleGameOpeningView;
import com.yvmartor.swingy.views.console.ConsoleGameOverView;
import com.yvmartor.swingy.views.gui.GUIDirectionView;
import com.yvmartor.swingy.views.gui.GUIGameOpeningView;
import com.yvmartor.swingy.views.gui.GUIGameOverView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.yvmartor.swingy.controller.SelectHeroController.createAndRegisterVillains;
import static com.yvmartor.swingy.models.tools.Tools.DIRECTIONS_TAB;

public class GameOverController {
    private GameOver model;
    private ConsoleGameOverView consoleView;
    private GUIGameOverView GUIView;
    private JFrame mainFrame;

    public GameOverController(GameOver model, JFrame mainFrame, ConsoleGameOverView consolView, GUIGameOverView GUIView){
        this.model = model;
        this.consoleView = consolView;
        this.GUIView = GUIView;
        this.mainFrame = mainFrame;
    }

    public void updateConsoleView()  {
        consoleView.printGameOver(model.getWorldMap(), model.getQuestion());
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("[1-3]")) {
            ConsoleStringColor.error("You must choice a number between 1-3.");
            scanner = new Scanner(System.in);
        }
        int resp = scanner.nextInt();
        if (resp == 1){
            Hero retry = new Hero();
            retry.copy(model.getWorldMap().getRetryHero());
            model.setWorldMap(null);
            WorldMap worldMap= new WorldMap();
            retry.registerWorldMap(worldMap);
            createAndRegisterVillains(worldMap);
            Direction model = new DirectionBuilder().hero(retry).options(DIRECTIONS_TAB).worldMap(worldMap).build();
            ConsoleDirectionView view = new ConsoleDirectionView();
            DirectionController controller = new DirectionController(model, null, view, null);
            controller.updateConsoleView();
        } else if (resp == 2){
            model.setWorldMap(null);
            ArrayList<String> options = new ArrayList<String>();
            options.add("1)" + " Play with a new hero\n");
            options.add("2)" + " Select one of your hero\n");
            GameOpening gameOpeningModel = new GameOpeningBuilder()
                    .title("\nWelcome to Swingy\n")
                    .options(options)
                    .image("/images/landscape.jpg")
                    .build();
            ConsoleGameOpeningView consoleGameOpeningView = new ConsoleGameOpeningView();
            GameOpeningController controller = new GameOpeningController(
                    gameOpeningModel,
                    consoleGameOpeningView,
                    null);
            try {
                controller.updateView();
            } catch (IOException e) {
                ConsoleStringColor.error(
                        "AN ERROR OCCURED, GAME OVER VIEW CAN'T BE DISPLAY. FORGIVENESS FOR THE DESAGREMENT GENERATED");
                System.exit(-1);
            }
        } else if (resp == 3){
            System.exit(0);
        }
    }

    public void updateGUIView(){
        GUIView.printGameOver(model.getWorldMap(), model.getQuestion());
        ArrayList<JButton> game_over_buttons = GUIView.getOptions();

        //RETRY
        game_over_buttons.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hero retry = new Hero();
                retry.copy(model.getWorldMap().getRetryHero());
                model.getWorldMap().getMapFrame().dispose();
                model.setWorldMap(null);
                WorldMap newWorldMap= new WorldMap();
                retry.registerWorldMap(newWorldMap);
                createAndRegisterVillains(newWorldMap);
                Direction model = new DirectionBuilder().hero(retry).options(DIRECTIONS_TAB).worldMap(newWorldMap).build();
                GUIDirectionView view = new GUIDirectionView(mainFrame);
                DirectionController controller = new DirectionController(model, mainFrame, null, view);
                controller.updateGUIView();
            }
        });

        //BACK TO THE MENU
        game_over_buttons.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getWorldMap().getMapFrame().dispose();
                mainFrame.dispose();
                model.setWorldMap(null);
                ArrayList<String> options = new ArrayList<String>();
                options.add("1)" + " Play with a new hero\n");
                options.add("2)" + " Select one of your hero\n");
                GameOpening gameOpeningModel = new GameOpeningBuilder()
                        .title("\nWelcome to Swingy\n")
                        .options(options)
                        .image("/images/landscape.jpg")
                        .build();
                GUIGameOpeningView guiGameOpeningView = new GUIGameOpeningView();
                GameOpeningController controller = new GameOpeningController(
                        gameOpeningModel,
                        null,
                        guiGameOpeningView);
                try {
                    controller.updateView();
                } catch (IOException ioException) {
                    ConsoleStringColor.error(
                            "AN ERROR OCCURED, GAME OPENING VIEW CAN'T BE DISPLAY. " +
                                    "FORGIVENESS FOR THE DESAGREMENT GENERATED");
                    System.exit(-1);
                }
            }
        });

        //QUIT
        game_over_buttons.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
