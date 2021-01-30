package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

import javax.swing.*;
import java.util.ArrayList;

public class GUIFightTellingView {
    private ArrayList<JButton> continue_button;


    public void printFightTelling(WorldMap worldMap, Villain villain, int winner, JFrame mainFrame){
        String ask = "<html>" + worldMap.getFightTelling().replace("\n", "<br>") + "<html>";
        worldMap.setFightTelling("");
        AdventureViewDirector director = new AdventureViewDirector();
        director.setAdventureViewBuilder(new GUIFightTellingViewBuilder(winner));
        director.constructAdventure(worldMap, ask, villain);
        AdventureView adventureView = director.getAdventureView();
        continue_button = adventureView.getAction_buttons();

        JPanel contentPane = (JPanel) mainFrame.getContentPane();
        mainFrame.setVisible(true);
        contentPane.removeAll();
        contentPane.add(adventureView);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public ArrayList<JButton> getContinue_button() {
        return continue_button;
    }
}
