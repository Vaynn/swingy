package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;
import com.yvmartor.swingy.models.scenario.fight_or_run.FightOrRun;
import com.yvmartor.swingy.models.tools.Tools;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.views.console.ConsoleFightOrRunView;
import com.yvmartor.swingy.views.gui.GUIFightOrRunView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public FightOrRunController(FightOrRun model, ConsoleFightOrRunView consoleView, GUIFightOrRunView GUIView){
        this.model = model;
        this.consoleView = consoleView;
        this.GUIView = GUIView;
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

        worldMap.setFightTelling("");
        Object[] fight =  worldMap.fight(villain); //Simulation of the fight. It returns the fight telling and the winner
        GUIView.printGUIFightOrRun(worldMap, villain);
       /* if ((int)fight[1] == VILLAIN_DEATH){
            //increase user xp and level up if he reaches the next level
            boolean levelUp = worldMap.updateXP(villain.getWinXp());
            gUIView.printWinXP(levelUp, villain.getWinXp(), worldMap);
            continue_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gUIView.printGUIAdventureView(worldMap, null, villain, FIGHT_TELLING_MODE);
                }
            });
            Artefact villainArtefact = villain.getArtefact();
            if (villainArtefact.getName().compareTo("None") != 0) { //check if villain hold an artefact
                Artefact heroArtefact = getHeroArtefact(villainArtefact, hero);
                gUIView.printKeepArtefactAsk(villain, heroArtefact, worldMap);
                String[] options = {"YES", "NO"};
                gUIView.printGUIAdventureView(worldMap, options, villain, FIGHT_TELLING_MODE);
                ArrayList <JButton> artefact = gUIView.getBoolean_actions();
                System.out.println(artefact.size());

                //YES
                artefact.get(0).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        worldMap.updateArtefact(villainArtefact);
                        gUIView.printKeepArtefactChoice(true, worldMap);
                        gUIView.printGUIAdventureView(worldMap, null, villain, FIGHT_TELLING_MODE);

                    }
                });

                //NO
                artefact.get(1).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        gUIView.printKeepArtefactChoice(false, worldMap);
                        gUIView.printGUIAdventureView(worldMap, null, villain, FIGHT_TELLING_MODE);
                    }
                });
            }

            worldMap.unregisterVilain(villain);
            displayWithTimer(worldMap, DIRECTIONS_TAB, null, MOVE_MODE);
        } else if ((int)fight[1] == HERO_DEATH){
            System.out.println("HERO is dead");
        }*/
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
                Artefact heroArtefact = getHeroArtefact(villainArtefact, hero);
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

    public Artefact getHeroArtefact(Artefact villainArtefact, Hero hero){

        Artefact heroArtefact = null;
        heroArtefact = villainArtefact.getIncreasedStat().compareTo("defense") == 0
                ? hero.getArmor()
                : villainArtefact.getIncreasedStat().compareTo("attack") == 0
                ? hero.getWeapon()
                : villainArtefact.getIncreasedStat().compareTo("hit points") == 0
                ? hero.getHelm()
                : heroArtefact;
        return heroArtefact;
    }

    private void displayWithTimer(WorldMap worldMap, String[] options, Villain villain, int mode){
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("timer");

            }
        });
        timer.setRepeats(false);
        timer.start();
    }

}
