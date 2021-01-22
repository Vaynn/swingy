package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.Swingy;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static java.lang.Math.round;

public class GUIAdventureView {
    JFrame mainFrame;
    JFrame mapFrame;
    ArrayList<JButton> moves = new ArrayList<JButton>();
    int dimension;
    private Font font = new Font("Courier", Font.ITALIC, 20);

    public GUIAdventureView(JFrame frame){
        this.mainFrame = frame;
    }
    public void printGUIAdventureView(WorldMap worldMap, String[] options){
        dimension = worldMap.getDimension();

        //Display Map frame with hero location
        CreateMapFrame frame = new  CreateMapFrame();
        mapFrame = frame.getMapFrame();
        displayMapFrame(worldMap.getHero());

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

        //Display question (move)
        JLabel direction = new JLabel("What do you want to do ?");
        direction.setBorder(new EmptyBorder(200,280,0,0));
        direction.setForeground(Color.green);
        direction.setHorizontalAlignment(JLabel.CENTER);
        direction.setVerticalAlignment(JLabel.CENTER);
        container.add(direction, BorderLayout.CENTER);


        //Display buttons direction
        JPanel orientationButtons = new JPanel(new GridBagLayout());
        orientationButtons.setBackground(Color.BLACK);
        orientationButtons.setSize(100,100);
        GridBagConstraints c = new GridBagConstraints();


        for (int i = 0; i < options.length; i++){
            moves.add(new JButton(options[i]));
        }

        c.gridx = 1;
        c.gridy = 0;
        orientationButtons.add(moves.get(0), c);

        c.gridx = 2;
        c.gridy = 1;
        orientationButtons.add(moves.get(1), c);

        c.gridx = 1;
        c.gridy = 2;
        orientationButtons.add(moves.get(2), c);

        c.gridx = 0;
        c.gridy = 1;
        orientationButtons.add(moves.get(3), c);

        container.add(orientationButtons, BorderLayout.SOUTH);


        //Display all in Frame
        JPanel contentPane = (JPanel) mainFrame.getContentPane();
        mainFrame.setVisible(true);
        contentPane.removeAll();
        contentPane.add(container);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public void displayMapFrame(Hero hero){
        int[] current_coordinates = hero.getCoordinates().getCoordinates();
        int location = (current_coordinates[0] - 1) * dimension + (current_coordinates[1] - 1);
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

    public ArrayList<JButton> getMoves() {
        return moves;
    }
}
