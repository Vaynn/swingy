package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.Swingy;
import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static com.yvmartor.swingy.models.tools.Tools.*;
import static java.lang.Math.round;

public class GUIAdventureView {
    JFrame mainFrame;
    JFrame mapFrame;
    ArrayList<JButton> moves = new ArrayList<JButton>();
    ArrayList<JButton> fight_actions = new ArrayList<JButton>();
    ArrayList<JButton> boolean_actions = new ArrayList<JButton>();
    int dimension;
    private Font font = new Font("Courier", Font.ITALIC, 20);
    ArrayList<String> meet_ennemy_actions = new ArrayList<String>();

    public GUIAdventureView(JFrame frame){
        this.mainFrame = frame;
        this.meet_ennemy_actions.add("Fight");
        this.meet_ennemy_actions.add("Run");
    }
    public void printGUIAdventureView(WorldMap worldMap, String[] options, Villain villain, int mode){
        dimension = worldMap.getDimension();

        //Display Map frame with hero location
        CreateMapFrame frame = new  CreateMapFrame();
        if (mapFrame == null)
            mapFrame = frame.getMapFrame();
        displayMapFrame(worldMap.getHero(), mode);

        //set container
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout(5, 5));
        container.setBackground(Color.BLACK);
        container.setBorder(new EmptyBorder(0,0,300,0));

        //title
        JLabel titleLabel = new JLabel("Try to get out the labyrinth.");
        titleLabel.setForeground(Color.cyan);
        titleLabel.setFont(font);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.CENTER);
        titleLabel.setBorder(new EmptyBorder(20, 0, 50, 0));
        container.add(titleLabel, BorderLayout.NORTH);

        //Hero stats
        JPanel heroPanel = new HeroCard(worldMap.getHero()).getHeroMiniCard();
        heroPanel.setSize(100, 200);
        container.add(heroPanel, BorderLayout.EAST);

        //Display question respect of MOVE OR FIGHT mode
        if (mode == MOVE_MODE){
            JLabel action_question = getActionQuestion("Where do you want to go ?\n");
            container.add(action_question, BorderLayout.CENTER);
        } else if (mode == FIGHT_MODE){
            JLabel action_question = getActionQuestion("A " + villain.getName() + " attacked you !\nWhat do you want to do ?");
            container.add(action_question, BorderLayout.CENTER);
        } else if (mode == FIGHT_TELLING_MODE){
            JLabel action_question = getActionQuestion(
                    "<html>" +
                    worldMap.getFightTelling().replace("\n", "<br>") +
                    "</html>");
            container.add(action_question, BorderLayout.CENTER);
        }

        //Display buttons direction or fight choices
        JPanel actionButtons = new JPanel(new GridBagLayout());
        actionButtons.setBackground(Color.BLACK);
        actionButtons.setSize(100,100);
        GridBagConstraints c = new GridBagConstraints();

        if (mode == MOVE_MODE) {
            for (int i = 0; i < options.length; i++) {
                moves.add(new JButton(options[i]));
            }

            //NORTH
            c.gridx = 1;
            c.gridy = 0;
            actionButtons.add(moves.get(0), c);

            //EAST
            c.gridx = 2;
            c.gridy = 1;
            actionButtons.add(moves.get(1), c);

            //SOUTH
            c.gridx = 1;
            c.gridy = 2;
            actionButtons.add(moves.get(2), c);

            //WEST
            c.gridx = 0;
            c.gridy = 1;
            actionButtons.add(moves.get(3), c);
        } else if (mode == FIGHT_MODE){
            for (int i = 0; i < meet_ennemy_actions.size(); i++) {
                fight_actions.add(new JButton(meet_ennemy_actions.get(i)));
            }
            //FIGHT
            c.gridx = 2;
            c.gridy = 1;
            actionButtons.add(fight_actions.get(1), c);

            //RUN
            c.gridx = 0;
            c.gridy = 1;
            actionButtons.add(fight_actions.get(0), c);
        }
        else if (mode == FIGHT_TELLING_MODE && villain.getArtefact().getName().compareTo("None") != 0){
            for (int i = 0; i < options.length; i++) {
                boolean_actions.add(new JButton(options[i]));
            }

            //TRUE
            c.gridx = 2;
            c.gridy = 1;
            actionButtons.add(boolean_actions.get(1), c);

            //False
            c.gridx = 0;
            c.gridy = 1;
            actionButtons.add(boolean_actions.get(0), c);
        }
        container.add(actionButtons, BorderLayout.SOUTH);

        //IN FIGHT_MODE DISPLAY ENEMY IMAGE
        if (mode == FIGHT_MODE || mode == FIGHT_TELLING_MODE) {
            InputStream resourceAsStream = Swingy.class.getResourceAsStream(villain.getImage());
            try {
                Image image = ImageIO.read(resourceAsStream);
                JLabel label1 = new JLabel(new ImageIcon(image));

                container.add(label1, BorderLayout.WEST);
            } catch (IOException e) {
                System.err.println(e);
            }
        }

        //Display all in Frame
        JPanel contentPane = (JPanel) mainFrame.getContentPane();
        mainFrame.setVisible(true);
        contentPane.removeAll();
        contentPane.add(container);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public void displayMapFrame(Hero hero, int mode){
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
                    System.err.println(e);
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
    private JLabel getActionQuestion(String question){
        JLabel direction = new JLabel(question);
        direction.setBorder(new EmptyBorder(200,280,0,0));
        direction.setForeground(Color.green);
        direction.setHorizontalAlignment(JLabel.CENTER);
        direction.setVerticalAlignment(JLabel.CENTER);
        return direction;
    }

    public void printKeepArtefactAsk(Villain villain, Artefact heroArtefact, WorldMap worldMap){
        worldMap.setFightTelling("Well Done! You defeated the " + villain.getName() + "!<br>");
        worldMap.setFightTelling(
                "He dropped "
                        + villain.getArtefact().getName()
                        + ". It would increase your "
                        + villain.getArtefact().getIncreasedStat()
                        + " by "
                        +villain.getArtefact().getPoints() +".<br>");
        if (heroArtefact.getName().compareTo("None") != 0) {
            worldMap.setFightTelling("For now you are wearing a "
                    + heroArtefact.getName()
                    + " with an increase of "
                    + heroArtefact.getPoints()
                    + ".<br>");
        }
        worldMap.setFightTelling("Do you want to wear it ? <br>");
    }

    public ArrayList<JButton> getMoves() {
        return moves;
    }

    public ArrayList<JButton> getFight_actions() {
        return fight_actions;
    }
}
