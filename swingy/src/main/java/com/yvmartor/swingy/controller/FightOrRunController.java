package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.artefacts.Armor;
import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.artefacts.Helm;
import com.yvmartor.swingy.models.artefacts.Weapon;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;
import com.yvmartor.swingy.models.scenario.fight_or_run.FightOrRun;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.views.console.ConsoleFightOrRunView;

import java.util.Scanner;

import static com.yvmartor.swingy.models.tools.Tools.HERO_DEATH;
import static com.yvmartor.swingy.models.tools.Tools.VILLAIN_DEATH;

public class FightOrRunController{
    private FightOrRun model;
    private ConsoleFightOrRunView consoleView;
    private Scanner fight_choice;
    private Scanner artefact_choice;
    private static final int FIGHT = 1;
    private static final int RUN = 2;

    public FightOrRunController(FightOrRun model, ConsoleFightOrRunView consoleView){
        this.model = model;
        this.consoleView = consoleView;
    }

    public void updateConsoleView(){
        Hero hero = model.getHero();
        Villain villain = model.getVilain();
        WorldMap worldMap = model.getHero().getWorldMap();

        consoleView.printFightOrRun(hero, villain, model.getQuestion());
        //TODO Check user input
        fight_choice = new Scanner(System.in);
        model.getQuestion().setResponse(fight_choice.nextInt());
        int resp = model.getQuestion().getResponse();
        if (resp == FIGHT){
            Object[] fight =  worldMap.fight(villain); //Simulation of the fight. It returns the fight telling and the winner
            ConsoleStringColor.fightTelling((String)fight[0]);

            //CASE: the player win
            if ((int)fight[1] == VILLAIN_DEATH){

                //check if the villain hold an artefact and propose it to the player
                Artefact villainArtefact = villain.getArtefact();
                if (villainArtefact.getName().compareTo("None") != 0) {
                    Artefact heroArtefact = null;
                    heroArtefact = villainArtefact.getIncreasedStat().compareTo("defense") == 0
                            ? hero.getArmor()
                            : villainArtefact.getIncreasedStat().compareTo("attack") == 0
                            ? hero.getWeapon()
                            : villainArtefact.getIncreasedStat().compareTo("hit points") == 0
                            ? hero.getHelm()
                            : heroArtefact;
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
                }
            else if ((int)fight[1] == HERO_DEATH)
                //TODO GameOver view
                System.out.println("VILLAIN WIN");
        }
    }
}
