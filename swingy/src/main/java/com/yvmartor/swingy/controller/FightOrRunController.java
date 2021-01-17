package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.scenario.fight_or_run.FightOrRun;
import com.yvmartor.swingy.views.console.ConsoleFightOrRunView;

public class FightOrRunController{
    private FightOrRun model;
    private ConsoleFightOrRunView consoleView;

    public FightOrRunController(FightOrRun model, ConsoleFightOrRunView consoleView){
        this.model = model;
        this.consoleView = consoleView;
    }

    public void updateConsoleView(){
        consoleView.printFightOrRun(model.getHero(), model.getVilain(), model.getQuestion());
    }
}
