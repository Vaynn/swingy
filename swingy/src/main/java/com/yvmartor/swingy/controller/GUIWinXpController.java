package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.direction.Direction;
import com.yvmartor.swingy.models.scenario.direction.DirectionBuilder;
import com.yvmartor.swingy.models.scenario.gui_fight_telling.GuiFightTelling;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.views.gui.GUIArtefactChoiceView;
import com.yvmartor.swingy.views.gui.GUIDirectionView;
import com.yvmartor.swingy.views.gui.GUIWinXpView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.yvmartor.swingy.models.tools.Tools.DIRECTIONS_TAB;
import static com.yvmartor.swingy.models.tools.Tools.VILLAIN_DEATH;

public class GUIWinXpController {
    private GuiFightTelling model;
    private GUIWinXpView view;
    private int winner;

    public GUIWinXpController(GuiFightTelling model, GUIWinXpView view, int winner){
        this.model = model;
        this.view = view;
        this.winner = winner;
    }

    public void updateView(){
        WorldMap worldMap = model.getWorldMap();
        Villain villain = model.getVillain();
        JFrame mainFrame = model.getMainFrame();
        boolean levelUp = worldMap.updateXP(villain.getWinXp());
        view.printWinXpView(worldMap, villain, winner, levelUp, mainFrame);

        ArrayList<JButton> continue_button = view.getContinue_button();

        if (winner == VILLAIN_DEATH){
            continue_button.get(0).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (villain.getArtefact().getName().compareTo("None") != 0) {
                        GUIArtefactChoiceView view = new GUIArtefactChoiceView();
                        GuiFightTelling model = new GuiFightTelling(worldMap, villain, mainFrame);
                        GUIArtefactChoiceController controller = new GUIArtefactChoiceController(model, view, winner);
                        controller.updateView();
                    }
                    else{
                        worldMap.unregisterVilain(villain);
                        GUIDirectionView view = new GUIDirectionView(mainFrame);
                        Direction model = new DirectionBuilder()
                                .hero(worldMap.getHero())
                                .options(DIRECTIONS_TAB)
                                .worldMap(worldMap)
                                .build();
                        DirectionController controller = new DirectionController(model, mainFrame, null, view);
                        controller.updateGUIView();
                    }
                }
            });
        }
    }
}
