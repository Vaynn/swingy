package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.Swingy;
import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;
import com.yvmartor.swingy.models.villains.Villain;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class GUIDirectionView {
    private JFrame mainFrame;
    private JFrame mapFrame;
    private ArrayList<JButton> moves;
    int dimension;

    public GUIDirectionView(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void printGUIDirectionView(WorldMap worldMap, String[] options, Villain villain) {
        dimension = worldMap.getDimension();

        //Display Map frame with hero location
        CreateMapFrame frame = new CreateMapFrame();
        if (worldMap.getMapFrame() == null) {
            mapFrame = frame.getMapFrame();
            worldMap.setMapFrame(mapFrame);
        }
        else
            mapFrame = worldMap.getMapFrame();
        displayMapFrame(worldMap.getHero());

        //Create Direction View with Adventure Panel Builder
        AdventureViewDirector director = new AdventureViewDirector();
        director.setAdventureViewBuilder(new GUIDirectionViewBuilder());
        director.constructAdventure(worldMap, "Where do you want to go ?", null);
        AdventureView adventureView = director.getAdventureView();
        moves = adventureView.getAction_buttons();

        //Display all in Frame
        JPanel contentPane = (JPanel) mainFrame.getContentPane();
        mainFrame.setVisible(true);
        contentPane.removeAll();
        contentPane.add(adventureView);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public void displayMapFrame(Hero hero){
        int[] current_coordinates = hero.getCoordinates().getCoordinates();
        int location = (current_coordinates[1] - 1) * dimension + (current_coordinates[0] - 1);
        JPanel panel = new JPanel(new GridLayout(dimension, dimension, 1, 1));
        panel.setSize(100, 100);
        panel.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        for (int i = 0; i < dimension * dimension; i++){
            JLabel map = new JLabel();
            if (i == location){
                InputStream resourceAsStream = Swingy.class.getResourceAsStream(hero.getGif());
                try {
                    Image image = ImageIO.read(resourceAsStream);
                    map = new JLabel(new ImageIcon(image));

                } catch (IOException e){
                    ConsoleStringColor.error("IMPOSSIBLE TO FIND THE PICTURE");
                }
                map.setBorder(BorderFactory.createLineBorder(Color.RED));
                map.setBackground(Color.BLACK);
            }

            else {
                map.setText("");
                map.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                map.setBackground(Color.BLACK);
            }
            panel.add(map);
        }
        JPanel contentPane = (JPanel) mapFrame.getContentPane();
        mapFrame.setVisible(true);
        contentPane.removeAll();
        contentPane.add(panel);
        contentPane.revalidate();
        contentPane.repaint();
    }

    //return JLabel question
    JLabel getActionQuestion(String question){
        JLabel direction = new JLabel(question);
        direction.setBorder(new EmptyBorder(200,280,0,0));
        direction.setForeground(Color.green);
        direction.setHorizontalAlignment(JLabel.CENTER);
        direction.setVerticalAlignment(JLabel.CENTER);
        return direction;
    }

    public void printKeepArtefactAsk(Villain villain, Artefact heroArtefact, WorldMap worldMap){
        worldMap.setFightTelling("Well Done! You defeated the " + villain.getName() + "!<br>");
        worldMap.setFightTelling(worldMap.getFightTelling() +
                "He dropped "
                        + villain.getArtefact().getName()
                        + ". It would increase your "
                        + villain.getArtefact().getIncreasedStat()
                        + " by "
                        +villain.getArtefact().getPoints() +".<br>");
        if (heroArtefact.getName().compareTo("None") != 0) {
            worldMap.setFightTelling(worldMap.getFightTelling() + "For now you are wearing a "
                    + heroArtefact.getName()
                    + " with an increase of "
                    + heroArtefact.getPoints()
                    + ".<br>");
        }
        worldMap.setFightTelling(worldMap.getFightTelling() + "Do you want to wear it ? <br>");
    }

    public void printKeepArtefactChoice(boolean choice, WorldMap worldMap) {
        if (choice == true){
            worldMap.setFightTelling("You are now wearing your new artefact.<br>");
        } else {
            worldMap.setFightTelling("You left the artefact.<br>");
        }
    }

    public void printWinXP(boolean levelUp, int villainXp,WorldMap worldMap) {
        worldMap.setFightTelling("You won " + villainXp + "XP you now have " + (int)worldMap.getHero().getXp() + " XP.<br>");
        if (levelUp == true){
            worldMap.setFightTelling(worldMap.getFightTelling() + "You're level goes up to level " + worldMap.getHero().getLevel() + ". <br>");
        }
    }

    public ArrayList<JButton> getMoves() {
        return moves;
    }

    public JFrame getMapFrame() {
        return mapFrame;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }


}
