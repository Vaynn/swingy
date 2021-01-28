package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.question.Question;
import com.yvmartor.swingy.models.villains.Villain;

import javax.swing.*;
import javax.swing.text.html.Option;
import java.util.ArrayList;

public class GUIFightOrRunView {
    private JFrame mainFrame;
    private ArrayList<JButton> dual_choice;

    public GUIFightOrRunView(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void printGUIFightOrRun(WorldMap worldMap, Villain villain) {
        String ask = "<html>A " + villain.getName() + " attacked you !<br>What do you want to do ?<html>";
        AdventureViewDirector director = new AdventureViewDirector();
        director.setAdventureViewBuilder(new GUIFightOrRunViewBuilder());
        director.constructAdventure(worldMap, ask, villain);
        AdventureView adventureView = director.getAdventureView();
        dual_choice = adventureView.getAction_buttons();

        JPanel contentPane = (JPanel) mainFrame.getContentPane();
        mainFrame.setVisible(true);
        contentPane.removeAll();
        contentPane.add(adventureView);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public ArrayList<JButton> getDual_choice() {
        return dual_choice;
    }
}
