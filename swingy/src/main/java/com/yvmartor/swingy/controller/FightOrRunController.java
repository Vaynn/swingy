package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.artefacts.Armor;
import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.artefacts.Helm;
import com.yvmartor.swingy.models.artefacts.Weapon;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;
import com.yvmartor.swingy.models.scenario.adventure.Adventure;
import com.yvmartor.swingy.models.scenario.fight_or_run.FightOrRun;
import com.yvmartor.swingy.models.tools.Tools;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.views.console.ConsoleFightOrRunView;
import com.yvmartor.swingy.views.gui.GUIAdventureView;

import java.util.Scanner;

import static com.yvmartor.swingy.models.tools.Tools.*;

public class FightOrRunController{
    private FightOrRun model;
    private ConsoleFightOrRunView consoleView;
    private GUIAdventureView gUIView;
    private Scanner fight_choice;
    private Scanner artefact_choice;
    private static final int FIGHT = 1;
    private static final int RUN = 2;

    public FightOrRunController(FightOrRun model, ConsoleFightOrRunView consoleView, GUIAdventureView guiAdventureView){
        this.model = model;
        this.consoleView = consoleView;
        this.gUIView = guiAdventureView;

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
        if ((int)fight[1] == VILLAIN_DEATH){
            Artefact villainArtefact = villain.getArtefact();
            if (villainArtefact.getName().compareTo("None") != 0) {
                Artefact heroArtefact = getHeroArtefact(villainArtefact, hero);
                gUIView.printKeepArtefactAsk(villain, heroArtefact, worldMap);
                String[] options = {"YES", "NO"};
                gUIView.printGUIAdventureView(worldMap, options, villain, FIGHT_TELLING_MODE);
            } else {
                gUIView.printGUIAdventureView(worldMap, null, villain, FIGHT_TELLING_MODE);
            }
        } else if ((int)fight[1] == HERO_DEATH){
            System.out.println("HERO is dead");
        }
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

}
