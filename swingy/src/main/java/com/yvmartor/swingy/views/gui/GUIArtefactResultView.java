package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

import javax.swing.*;
import java.util.ArrayList;

public class GUIArtefactResultView {
    private ArrayList<JButton> continue_button;

    public void printArtefactResult(WorldMap worldMap, Villain villain, JFrame mainFrame, boolean keep){
        String ask;

        if (keep){
            ask = "<html>You are now wearing your new artefact.<br></html>";
        }
        else{
            ask = "<html>You left the artefact.<br></html>";
        }
        AdventureViewDirector director = new AdventureViewDirector();
        director.setAdventureViewBuilder(new GUIArtefactResultViewBuilder(keep));
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
