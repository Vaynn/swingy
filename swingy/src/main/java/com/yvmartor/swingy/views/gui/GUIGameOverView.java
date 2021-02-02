package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

import javax.swing.*;
import java.util.ArrayList;

public class GUIGameOverView {
    private JFrame mainFrame;
    private ArrayList<JButton> options;

    public GUIGameOverView(JFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public void printGameOver(WorldMap worldMap, String question){
        AdventureViewDirector director = new AdventureViewDirector();
        director.setAdventureViewBuilder(new GUIGameOverViewBuilder());
        director.constructAdventure(worldMap, question, null);
        AdventureView adventureView = director.getAdventureView();
        options = adventureView.getAction_buttons();

        JPanel contentPane = (JPanel) mainFrame.getContentPane();
        mainFrame.setVisible(true);
        contentPane.removeAll();
        contentPane.add(adventureView);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public ArrayList<JButton> getOptions() {
        return options;
    }
}
