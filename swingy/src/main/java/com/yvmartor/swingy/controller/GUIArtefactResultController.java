package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.direction.Direction;
import com.yvmartor.swingy.models.scenario.direction.DirectionBuilder;
import com.yvmartor.swingy.models.scenario.gui_fight_telling.GuiFightTelling;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.views.gui.GUIArtefactResultView;
import com.yvmartor.swingy.views.gui.GUIDirectionView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.yvmartor.swingy.models.tools.Tools.DIRECTIONS_TAB;

public class GUIArtefactResultController {
    private GuiFightTelling model;
    private GUIArtefactResultView view;
    private boolean keep;

    public GUIArtefactResultController(GuiFightTelling model, GUIArtefactResultView view, boolean keep){
        this.model = model;
        this.view = view;
        this.keep = keep;
    }

    public void updateView(){
        WorldMap worldMap = model.getWorldMap();
        Villain villain = model.getVillain();
        JFrame mainFrame = model.getMainFrame();

        view.printArtefactResult(worldMap, villain, mainFrame, keep);

        ArrayList<JButton> continue_button = view.getContinue_button();

        continue_button.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });
    }
}
