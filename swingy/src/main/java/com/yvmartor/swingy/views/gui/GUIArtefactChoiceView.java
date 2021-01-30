package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;
import com.yvmartor.swingy.models.villains.Villain;

import javax.swing.*;
import java.util.ArrayList;

public class GUIArtefactChoiceView {
    private ArrayList<JButton> artefact_choice;

    public void printArtefactChoice(WorldMap worldMap, Villain villain, JFrame mainFrame){
        String ask =
                "<html>"
                        + villain.getName()
                        + " dropped "
                        + villain.getArtefact().getName()
                        + ". It would increase your "
                        + villain.getArtefact().getIncreasedStat()
                        + " by " + villain.getArtefact().getPoints() + ".<br></html>";
        Artefact heroArtefact = worldMap.getHeroArtefact(villain.getArtefact(), worldMap.getHero());
        if (heroArtefact.getName().compareTo("None") != 0) {
            ask += "For now you are wearing a "
                    + heroArtefact.getName()
                    + " with an increase of "
                    + heroArtefact.getPoints()
                    + ".<br><html>";
        }
        ask += "<html>Do you want to wear it ? <br></html>";

        AdventureViewDirector director = new AdventureViewDirector();
        director.setAdventureViewBuilder(new GUIArtefactChoiceViewBuilder());
        director.constructAdventure(worldMap, ask, villain);
        AdventureView adventureView = director.getAdventureView();

        artefact_choice = adventureView.getAction_buttons();

        JPanel contentPane = (JPanel) mainFrame.getContentPane();
        mainFrame.setVisible(true);
        contentPane.removeAll();
        contentPane.add(adventureView);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public ArrayList<JButton> getArtefact_choice() {
        return artefact_choice;
    }
}


