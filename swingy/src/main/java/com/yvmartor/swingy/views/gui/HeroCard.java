package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.Swingy;
import com.yvmartor.swingy.models.hero.Hero;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import static java.awt.GridBagConstraints.*;

public class HeroCard extends JPanel {
    private Hero hero;
    private JPanel container = new JPanel();
    private JLabel classLabel = new JLabel();
    private JLabel nameLabel = new JLabel();
    private JLabel xpLabel = new JLabel();
    private JLabel title = new JLabel();

    public HeroCard(Hero hero){
        this.hero = hero;
    }

    public JPanel getHeroCard() throws IOException{
        Font font = new Font("Courier", Font.ITALIC, 35);
        JPanel mega = new JPanel();
        mega.setLayout(new BorderLayout());
        mega.setBackground(Color.BLACK);
        title.setText("Select your Hero");
        title.setForeground(Color.cyan);
        title.setFont(font);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setBorder(new EmptyBorder(20, 0, 0, 0));
        mega.add(title, BorderLayout.NORTH);
        container.setBackground(Color.BLACK);
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        InputStream resourceAsStream = Swingy.class.getResourceAsStream(hero.getImage());
        try {
            Image image = ImageIO.read(resourceAsStream);
            JLabel label1 = new JLabel(new ImageIcon(image));
            container.add(label1);
        } catch (IOException e){
            System.err.println(e);
        }
        BoxLayout stat = new BoxLayout(container, BoxLayout.X_AXIS);
        classLabel.setText("CLASS: " + hero.getHeroClass());
        classLabel.setForeground(Color.white);
        classLabel.setFont(font);
        stat.addLayoutComponent("class", classLabel);
        mega.add(container, BorderLayout.CENTER);
        /*container.setBackground(Color.BLACK);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        constraints.insets = new Insets(0, 0, 10, 0);
        InputStream resourceAsStream = Swingy.class.getResourceAsStream(hero.getImage());
        try {
            Image image = ImageIO.read(resourceAsStream);
            JLabel label1 = new JLabel(new ImageIcon(image));
            container.add(label1, constraints);
        } catch (IOException e){
            System.err.println(e);
        }
        constraints.gridx = 6;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 10, 0, 0);
        classLabel.setText("CLASS: " + hero.getHeroClass());
        classLabel.setForeground(Color.white);
        constraints.anchor = LINE_START;
        classLabel.setFont(font);
        classLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
        container.add(classLabel, constraints);
        constraints.gridx = 6;
        constraints.gridy = 2;
        nameLabel.setText("NAME: " + hero.getName());
        nameLabel.setForeground(Color.white);
        constraints.anchor = LINE_START;
        nameLabel.setFont(font);
        nameLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
        container.add(nameLabel, constraints);
        constraints.gridx = 6;
        constraints.gridy = 3;
        xpLabel.setText("XP: " + hero.getXp());
        xpLabel.setForeground(Color.white);
        xpLabel.setFont(font);
        xpLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
        constraints.anchor = LINE_START;
        container.add(xpLabel, constraints);
        mega.add(container, BorderLayout.CENTER);
         */

        return mega;
    }
}
