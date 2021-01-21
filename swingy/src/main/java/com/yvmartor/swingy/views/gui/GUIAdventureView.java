package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;

import javax.swing.*;
import java.awt.*;

import static java.lang.Math.round;

public class GUIAdventureView {
    JFrame mainFrame;
    public GUIAdventureView(JFrame frame){
        this.mainFrame = frame;
    }
    public void printGUIAdventureView(WorldMap worldMap, String[] options){
        int middle = (int)round((double)worldMap.getDimension()/2);
        JPanel panel = new JPanel();
        JLabel[][] map = new JLabel[worldMap.getDimension()][worldMap.getDimension()];
        for (int i = 0; i < worldMap.getDimension(); i++){
            for (int y = 0; y < worldMap.getDimension(); y++){
                if (i == middle && y == middle) {
                    map[i][y] = new JLabel("O");
                    map[i][y].setBackground(Color.BLACK);
                }

                else {
                    map[i][y] = new JLabel("X");
                    map[i][y].setBackground(Color.BLACK);
                }
                panel.add(map[i][y]);
            }
        }
        JPanel contentPane = (JPanel) mainFrame.getContentPane();
        contentPane.removeAll();
        contentPane.add(panel);
        contentPane.revalidate();
        contentPane.repaint();
    }
}
