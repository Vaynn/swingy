package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

import javax.swing.*;
import java.util.ArrayList;

public class GUIDidIRunView {

    private ArrayList<JButton> continue_button;

    public void printDidIRun(WorldMap worldMap, Villain villain, boolean escape, JFrame mainFrame){
        String ask;
        if (escape)
            ask = "<html>You managed to escape.<br></html>";
        else
            ask = "<html>You stumbled, you will have to fight.<br></html>";

        AdventureViewDirector director = new AdventureViewDirector();
        director.setAdventureViewBuilder(new GUIDidIRunViewBuilder(escape));
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
