package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.gui_fight_telling.GuiFightTelling;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.views.gui.GUIArtefactChoiceView;
import com.yvmartor.swingy.views.gui.GUIArtefactResultView;
import com.yvmartor.swingy.views.gui.GUIWinXpView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.yvmartor.swingy.models.tools.Tools.VILLAIN_DEATH;

public class GUIArtefactChoiceController {

    private GuiFightTelling model;
    private GUIArtefactChoiceView view;
    private int winner;

    public GUIArtefactChoiceController(GuiFightTelling model, GUIArtefactChoiceView view, int winner){
        this.model = model;
        this.view = view;
        this.winner = winner;
    }

    public void updateView(){
        WorldMap worldMap = model.getWorldMap();
        Villain villain = model.getVillain();
        JFrame mainFrame = model.getMainFrame();

        view.printArtefactChoice(worldMap, villain, mainFrame);

        ArrayList<JButton> continue_button = view.getArtefact_choice();

        //keep
        continue_button.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                worldMap.updateArtefact(villain.getArtefact());
                GuiFightTelling model = new GuiFightTelling(worldMap, villain, mainFrame);
                GUIArtefactResultView view = new GUIArtefactResultView();
                GUIArtefactResultController controller = new GUIArtefactResultController(model, view, true);
                controller.updateView();
            }
        });

        //throw
        continue_button.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiFightTelling model = new GuiFightTelling(worldMap, villain, mainFrame);
                GUIArtefactResultView view = new GUIArtefactResultView();
                GUIArtefactResultController controller = new GUIArtefactResultController(model, view, false);
                controller.updateView();

            }
        });
    }
}
