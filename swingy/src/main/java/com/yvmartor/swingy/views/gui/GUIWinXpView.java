package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

import javax.swing.*;
import java.util.ArrayList;

public class GUIWinXpView {

    private ArrayList<JButton> continue_button;

    public void printWinXpView(WorldMap worldMap, Villain villain, int winner, boolean levelUp, JFrame mainFrame){
        String ask = printWinXP(levelUp, villain.getWinXp(), worldMap.getHero());
        AdventureViewDirector director = new AdventureViewDirector();
        director.setAdventureViewBuilder(new GUIWinXpViewBuilder());
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

    private String printWinXP(boolean levelUp, int villainXp, Hero hero) {
        String levelString;
        levelString = "<html>You won " + villainXp + "XP you now have " + (int)hero.getXp() + " XP.<br></html>";
        if (levelUp == true){
            levelString += "<html>You're level goes up to level " + hero.getLevel() + ". <br></html>";
        }
        return levelString;
    }
}
