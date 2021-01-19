package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;
import com.yvmartor.swingy.models.scenario.fight_or_run.FightOrRun;
import com.yvmartor.swingy.views.console.ConsoleFightOrRunView;

import java.util.Scanner;

import static com.yvmartor.swingy.models.tools.Tools.HERO_DEATH;
import static com.yvmartor.swingy.models.tools.Tools.VILLAIN_DEATH;

public class FightOrRunController{
    private FightOrRun model;
    private ConsoleFightOrRunView consoleView;
    private Scanner scan;
    private static final int FIGHT = 1;
    private static final int RUN = 2;

    public FightOrRunController(FightOrRun model, ConsoleFightOrRunView consoleView){
        this.model = model;
        this.consoleView = consoleView;
    }

    public void updateConsoleView(){
        consoleView.printFightOrRun(model.getHero(), model.getVilain(), model.getQuestion());
        WorldMap worldMap = model.getHero().getWorldMap();
        scan = new Scanner(System.in);
        model.getQuestion().setResponse(scan.nextInt());
        int resp = model.getQuestion().getResponse();
        if (resp == FIGHT){
            Object[] fight =  worldMap.fight(model.getVilain());
            ConsoleStringColor.fightTelling((String)fight[0]);
            if ((int)fight[1] == VILLAIN_DEATH)
                //TODO Check if villain hold an artefact and ask player if he want to wear it
                //TODO unregister villain idx of the map. (check if it's change the other idx)
                System.out.println("HERO WIN");
            else if ((int)fight[1] == HERO_DEATH)
                //TODO GameOver view
                System.out.println("VILLAIN WIN");
        }
    }
}
