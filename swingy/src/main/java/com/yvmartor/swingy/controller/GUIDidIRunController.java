package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.direction.Direction;
import com.yvmartor.swingy.models.scenario.direction.DirectionBuilder;
import com.yvmartor.swingy.models.scenario.gui_fight_telling.GuiFightTelling;
import com.yvmartor.swingy.models.tools.Tools;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.views.gui.GUIDidIRunView;
import com.yvmartor.swingy.views.gui.GUIDirectionView;
import com.yvmartor.swingy.views.gui.GUIFightTellingView;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.yvmartor.swingy.models.tools.Tools.*;

public class GUIDidIRunController {
    private GuiFightTelling model;
    private GUIDidIRunView view;

    public GUIDidIRunController(GuiFightTelling model, GUIDidIRunView view){
        this.model = model;
        this.view = view;
    }

    public void updateView(){
        WorldMap worldMap = model.getWorldMap();
        Villain villain = model.getVillain();
        JFrame mainFrame = model.getMainFrame();

        int can_you_run = Tools.generateRandomInt(LUCK, 779);
        System.out.println(can_you_run);
        ArrayList<JButton> continue_button;

        //Managed to run
        if (can_you_run == LUCK){
            view.printDidIRun(worldMap, villain, true, mainFrame);
            continue_button = view.getContinue_button();
            continue_button.get(0).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Direction directionModel = new DirectionBuilder()
                            .hero(worldMap.getHero())
                            .options(DIRECTIONS_TAB)
                            .worldMap(worldMap)
                            .build();
                    GUIDirectionView directionView = new GUIDirectionView(mainFrame);
                    DirectionController controller = new DirectionController(
                            directionModel,
                            mainFrame,
                            null,
                            directionView);
                    controller.updateGUIView();
                }
            });
        }
        else {
            view.printDidIRun(worldMap, villain, false, mainFrame);
            continue_button = view.getContinue_button();
            continue_button.get(0).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    worldMap.setFightTelling("");
                    Object[] fight =  worldMap.fight(villain);
                    GUIFightTellingView view = new GUIFightTellingView();
                    GuiFightTelling model = new GuiFightTelling(worldMap, villain, mainFrame);
                    GUIFightTellingController controller = new GUIFightTellingController(model, view, (int)fight[1]);
                    controller.updateView();
                }
            });
        }
    }
}
