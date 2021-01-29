package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.direction.Direction;
import com.yvmartor.swingy.models.scenario.fight_or_run.FightOrRun;
import com.yvmartor.swingy.models.scenario.fight_or_run.FightOrRunBuilder;
import com.yvmartor.swingy.models.scenario.question.Question;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.views.console.ConsoleDirectionView;
import com.yvmartor.swingy.views.console.ConsoleFightOrRunView;
import com.yvmartor.swingy.views.gui.GUIDirectionView;
import com.yvmartor.swingy.views.gui.GUIFightOrRunView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import static com.yvmartor.swingy.models.tools.Tools.*;

public class DirectionController {
    private JFrame frame;
    private Direction model;
    private ConsoleDirectionView consoleView;
    private GUIDirectionView gUIView;
    private Scanner scanner;
    private int choice;
    private Hero hero;
    private WorldMap worldMap;
    ArrayList<String> options = new ArrayList<String>();

    public DirectionController(Direction model, JFrame mainframe, ConsoleDirectionView consoleView, GUIDirectionView gUIView){
        this.model = model;
        this.frame = mainframe;
        this.consoleView = consoleView;
        this.gUIView = gUIView;
        this.hero = model.getHero();
        this.worldMap = model.getWorldMap();
        this.options.add("Fight");
        this.options.add("Run");
    }

    public void updateConsoleView() {

        int destiny;

        while (true) {
            consoleView.printGameAdventure(hero, model.getOptions());
            //TODO Check user input
            scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            worldMap.updateHeroCoordinates(choice);
            Villain enemy = worldMap.isHeroMeetVilain(); //After the hero move , check if we meet an enemy
            if (enemy != null) {
                String quest = "A " + enemy.getName() + " attacked you !\nWhat do you want to do ?";
                Question question = new Question(quest, options);
                FightOrRun fightOrRunModel = new FightOrRunBuilder()
                        .hero(hero)
                        .vilain(enemy)
                        .question(question)
                        .build();
                ConsoleFightOrRunView fightOrRunView = new ConsoleFightOrRunView();
                FightOrRunController controller = new FightOrRunController(fightOrRunModel, null, fightOrRunView, null);
                destiny = controller.updateConsoleView();
                if (destiny == HERO_DEATH){
                    break;
                }
            }
            if (worldMap.isHeroReachTheEdge() == true){
                destiny = VICTORY;
                break;
            }

        }
        if (destiny == HERO_DEATH){
            //TODO GAME OVER VIEW
            System.out.println("GAME OVER");
        }
        if (destiny == VICTORY){
            //TODO DB SAVE + ASK CONTINUE OR NOT.
            System.out.println("VICTORY");
        }
    }

    public void updateGUIView(){
        gUIView.printGUIDirectionView(worldMap, model.getOptions(), null);

            ArrayList<JButton> moves = gUIView.getMoves();
            moves.get(0).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    worldMap.updateHeroCoordinates(1);
                    Villain enemy = worldMap.isHeroMeetVilain();
                    if (enemy != null){
                        launchFightOrRunController(enemy);
                    }
                    gUIView.displayMapFrame(worldMap.getHero());
                }
            });

            moves.get(1).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    worldMap.updateHeroCoordinates(2);
                    Villain enemy = worldMap.isHeroMeetVilain();
                    if (enemy != null){
                        launchFightOrRunController(enemy);
                    }
                    gUIView.displayMapFrame(worldMap.getHero());
                }
            });

            moves.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                worldMap.updateHeroCoordinates(3);
                Villain enemy = worldMap.isHeroMeetVilain();
                if (enemy != null){
                    launchFightOrRunController(enemy);
                }
                gUIView.displayMapFrame(worldMap.getHero());
                }
            });

            moves.get(3).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                worldMap.updateHeroCoordinates(4);
                Villain enemy = worldMap.isHeroMeetVilain();
                if (enemy != null){
                    launchFightOrRunController(enemy);
                }
                gUIView.displayMapFrame(worldMap.getHero());
                }
            });
    }

    private void launchFightOrRunController(Villain enemy){
        String quest = "A " + enemy.getName() + " attacked you !<br> What do you want to do ?";
        Question question = new Question(quest, options);
        FightOrRun fightOrRunModel = new FightOrRunBuilder()
                .hero(hero)
                .vilain(enemy)
                .question(question)
                .build();
        GUIFightOrRunView fightOrRunView = new GUIFightOrRunView(frame);
        FightOrRunController controller = new FightOrRunController(fightOrRunModel, frame, null, fightOrRunView);
        controller.updateGUIView();
    }
}
