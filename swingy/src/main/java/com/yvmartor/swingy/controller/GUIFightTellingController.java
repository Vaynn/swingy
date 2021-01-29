package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.gui_fight_telling.GuiFightTelling;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.views.gui.GUIFightTellingView;

public class GUIFightTellingController {
    private GuiFightTelling model;
    private GUIFightTellingView view;
    private int winner;

    public GUIFightTellingController(GuiFightTelling model, GUIFightTellingView view, int winner){
        this.model = model;
        this.view = view;
        this.winner = winner;
    }

    public void updateView(){
        WorldMap worldMap = model.getWorldMap();
        Villain villain = model.getVillain();

        view.printFightTelling(worldMap, villain, winner);
    }


}

