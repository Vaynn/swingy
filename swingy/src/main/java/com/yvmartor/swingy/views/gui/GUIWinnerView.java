package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.map.WorldMap;

import javax.swing.*;
import java.util.ArrayList;

public class GUIWinnerView {

    private JFrame mainFrame;
    private ArrayList<JButton> options;

    public GUIWinnerView(JFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    public void printWinnerView(WorldMap worldMap, String question){
        AdventureViewDirector director = new AdventureViewDirector();
        director.setAdventureViewBuilder(new GUIWinnerViewBuilder());
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
