package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;
import com.yvmartor.swingy.models.scenario.fight_or_run.FightOrRun;
import com.yvmartor.swingy.models.scenario.gui_fight_telling.GuiFightTelling;
import com.yvmartor.swingy.models.tools.Tools;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.views.console.ConsoleFightOrRunView;
import com.yvmartor.swingy.views.gui.GUIFightOrRunView;
import com.yvmartor.swingy.views.gui.GUIFightTellingView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import static com.yvmartor.swingy.models.tools.Tools.*;

public class FightOrRunController{
    private FightOrRun model;
    private ConsoleFightOrRunView consoleView;
    private GUIFightOrRunView GUIView;
    private Scanner fight_choice;
    private Scanner artefact_choice;
    private static final int FIGHT = 1;
    private static final int RUN = 2;
    private JFrame mainFrame;

    public FightOrRunController(FightOrRun model, JFrame frame, ConsoleFightOrRunView consoleView, GUIFightOrRunView GUIView){
        this.model = model;
        this.consoleView = consoleView;
        this.GUIView = GUIView;
        this.mainFrame = frame;
    }

    public int updateConsoleView(){
        Hero hero = model.getHero();
        Villain villain = model.getVilain();
        WorldMap worldMap = model.getHero().getWorldMap();

        consoleView.printFightOrRun(hero, villain, model.getQuestion());
        //TODO Check user input
        fight_choice = new Scanner(System.in);
        model.getQuestion().setResponse(fight_choice.nextInt());
        int resp = model.getQuestion().getResponse();
        if (resp == FIGHT){
            return fight(worldMap, villain, hero);
        }
        else if (resp == RUN){
            return run(worldMap, villain, hero);
        }
        return ERROR;
    }

    public void updateGUIView(){
        Hero hero = model.getHero();
        Villain villain = model.getVilain();
        WorldMap worldMap = model.getHero().getWorldMap();

        GUIView.printGUIFightOrRun(worldMap, villain);
        ArrayList<JButton> fight_choice = GUIView.getDual_choice();

        //FIGHT
        fight_choice.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Simulation of the fight. It returns the fight telling and the winner
                worldMap.setFightTelling("");

                Object[] fight =  worldMap.fight(villain);
                GUIFightTellingView view = new GUIFightTellingView();
                GuiFightTelling model = new GuiFightTelling(worldMap, villain, mainFrame);
                GUIFightTellingController controller = new GUIFightTellingController(model, view, (int)fight[1]);
                controller.updateView();
            }
        });
    }

    //Fight simulation: manage victory or defeat + artefact win and xp increase
    private int fight(WorldMap worldMap, Villain villain, Hero hero){
        Object[] fight =  worldMap.fight(villain); //Simulation of the fight. It returns the fight telling and the winner
        ConsoleStringColor.fightTelling((String)fight[0]);

        //CASE: the player win
        if ((int)fight[1] == VILLAIN_DEATH){

            //check if the villain hold an artefact and propose it to the player
            Artefact villainArtefact = villain.getArtefact();
            if (villainArtefact.getName().compareTo("None") != 0) {
                Artefact heroArtefact = worldMap.getHeroArtefact(villainArtefact, hero);
                consoleView.printKeepArtefactAsk(villain, heroArtefact);
                //TODO Check user input
                artefact_choice = new Scanner(System.in);
                if (artefact_choice.nextInt() == 1) {
                    worldMap.updateArtefact(villainArtefact);
                    consoleView.printKeepArtefactChoice(true);
                }
                else
                    consoleView.printKeepArtefactChoice(false);

            }
            //increase user xp and level up if he reaches the next level
            boolean levelUp = worldMap.updateXP(villain.getWinXp());
            consoleView.printWinXP(levelUp, villain.getWinXp(), worldMap.getHero());
            worldMap.unregisterVilain(villain);
            return VILLAIN_DEATH;
        }
        else if ((int)fight[1] == HERO_DEATH)
            return HERO_DEATH;
        return ERROR;
    }

    private int run(WorldMap worldMap, Villain villain, Hero hero){
        int can_you_run = Tools.generateRandomInt(776, LUCK);
        if (can_you_run == LUCK){
            consoleView.printCanIRun(true);
            return VILLAIN_DEATH;
        }
        else {
            consoleView.printCanIRun(false);
            return fight(worldMap, villain, hero);
        }
    }


}
