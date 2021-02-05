package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.game_over.GameOver;
import com.yvmartor.swingy.models.scenario.gui_fight_telling.GuiFightTelling;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.views.gui.GUIFightTellingView;
import com.yvmartor.swingy.views.gui.GUIGameOverView;
import com.yvmartor.swingy.views.gui.GUIWinXpView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.yvmartor.swingy.models.tools.Tools.HERO_DEATH;
import static com.yvmartor.swingy.models.tools.Tools.VILLAIN_DEATH;

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
        JFrame mainFrame = model.getMainFrame();

        view.printFightTelling(worldMap, villain, winner, mainFrame);

        ArrayList<JButton> continue_button = view.getContinue_button();

        if (winner == VILLAIN_DEATH){
            continue_button.get(0).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GUIWinXpView view = new GUIWinXpView();
                    GuiFightTelling model = new GuiFightTelling(worldMap, villain, mainFrame);
                    GUIWinXpController controller = new GUIWinXpController(model, view, winner);
                    controller.updateView();
                }
            });
        }
        else if (winner == HERO_DEATH){
            continue_button.get(0).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GameOver model = new GameOver(worldMap, "<html> GAME OVER!<br> What do you want to do ?<br></html>");
                    GUIGameOverView view = new GUIGameOverView(mainFrame);
                    GameOverController controller = new GameOverController(model, mainFrame, null, view);
                    controller.updateGUIView();
                }
            });

        }
    }


}

