package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.database.Database;
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
import com.yvmartor.swingy.views.console.ConsoleWinnerView;
import com.yvmartor.swingy.views.gui.GUIDirectionView;
import com.yvmartor.swingy.views.gui.GUIGameOpeningView;
import com.yvmartor.swingy.views.gui.GUIWinnerView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.yvmartor.swingy.controller.SelectHeroController.createAndRegisterVillains;
import static com.yvmartor.swingy.models.tools.Tools.DIRECTIONS_TAB;

public class WinnerController {
    private GameOver model;
    private ConsoleWinnerView consoleView;
    private GUIWinnerView gUIview;
    private JFrame mainFrame;


    public WinnerController(GameOver model, ConsoleWinnerView consoleView, GUIWinnerView gUIview, JFrame mainFrame){
        this.model = model;
        this.consoleView = consoleView;
        this.gUIview = gUIview;
        this.mainFrame = mainFrame;
    }

    public void updateConsoleView(){
        consoleView.printWinnerView(model.getWorldMap(), model.getQuestion());
        if (model.getWorldMap().getHero().getIdx() == -1) {
            try {
                int hero_idx = Database.createHero(model.getWorldMap().getHero());
                model.getWorldMap().getHero().setIdx(hero_idx);
            } catch (SQLException throwables) {
                ConsoleStringColor.error("IMPOSSIBLE TO SAVE THE GAME: Database corruption");
                System.exit(-1);
            }
        }
        else {
            try {
                Database.updateHero(model.getWorldMap().getHero());
            } catch (SQLException throwables) {
                ConsoleStringColor.error("IMPOSSIBLE TO SAVE THE GAME: Database corruption");
                System.exit(-1);
            }
        }

        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("[1-3]")) {
            ConsoleStringColor.error("You must choice a number between 1-3.");
            scanner = new Scanner(System.in);
        }
        int resp = scanner.nextInt();

        //CONTINUE
        if (resp == 1){
            Hero hero = model.getWorldMap().getHero();
            model.setWorldMap(null);
            WorldMap worldMap= new WorldMap();
            hero.registerWorldMap(worldMap);
            createAndRegisterVillains(worldMap);
            Direction model = new DirectionBuilder().hero(hero).options(DIRECTIONS_TAB).worldMap(worldMap).build();
            ConsoleDirectionView view = new ConsoleDirectionView();
            DirectionController controller = new DirectionController(model, null, view, null);
            controller.updateConsoleView();
        }
        //BACK TO THE MENU
        else if (resp == 2){
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
            } catch (IOException ioException) {
                ConsoleStringColor.error(
                        "AN ERROR OCCURED, GAME OPENING VIEW CAN'T BE DISPLAY. " +
                                "FORGIVENESS FOR THE DESAGREMENT GENERATED");
                System.exit(-1);
            }
        }
        //EXIT
        else if (resp == 3){
            System.exit(0);
        }
    }

    public void updateGUIView(){
        gUIview.printWinnerView(model.getWorldMap(), "<html>Congratulations, your progression has been saved" +
                "<br><br>" +
                "What do you want to do ?</html>");

        if (model.getWorldMap().getHero().getIdx() == -1){
            try {
                int hero_idx = Database.createHero(model.getWorldMap().getHero());
                model.getWorldMap().getHero().setIdx(hero_idx);
            } catch (SQLException throwables) {
                ConsoleStringColor.error("IMPOSSIBLE TO SAVE THE GAME: Database corruption");
                System.exit(-1);
            }
        }
        else {
            try {
                Database.updateHero(model.getWorldMap().getHero());
            } catch (SQLException throwables) {
                ConsoleStringColor.error("IMPOSSIBLE TO SAVE THE GAME: Database corruption");
                System.exit(-1);
            }
        }
        ArrayList<JButton> winner_buttons = gUIview.getOptions();

        //CONTINUE
        winner_buttons.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.getWorldMap().getMapFrame().dispose();
                Hero hero = model.getWorldMap().getHero();
                model.setWorldMap(null);
                WorldMap worldMap= new WorldMap();
                hero.registerWorldMap(worldMap);
                createAndRegisterVillains(worldMap);
                Direction model = new DirectionBuilder().hero(hero).options(DIRECTIONS_TAB).worldMap(worldMap).build();
                GUIDirectionView view = new GUIDirectionView(mainFrame);
                DirectionController controller = new DirectionController(model, mainFrame, null, view);
                controller.updateGUIView();
            }
        });

        //BACK TO THE MENU
        winner_buttons.get(1).addActionListener(new ActionListener() {
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
        winner_buttons.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
