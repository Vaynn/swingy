package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.scenario.fight_or_run.FightOrRun;
import com.yvmartor.swingy.views.console.ConsoleFightOrRunView;

import java.util.Scanner;

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
        scan = new Scanner(System.in);
        model.getQuestion().setResponse(scan.nextInt());
        int resp = model.getQuestion().getResponse();
        if (resp == FIGHT){

        }
    }
}
