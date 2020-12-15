package com.yvmartor.swingy.views.frames;

import com.yvmartor.swingy.Swingy;
import com.yvmartor.swingy.models.hero.Hero;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import static java.awt.GridBagConstraints.LINE_START;

public class HeroCard extends JPanel {
    private Hero hero;
    private JPanel container = new JPanel();
    private JLabel classLabel = new JLabel();
    private JLabel nameLabel = new JLabel();
    private JLabel xpLabel = new JLabel();

    public HeroCard(Hero hero){
        this.hero = hero;
    }

    public JPanel getHeroCard(){
        Font font = new Font("Courier", Font.ITALIC, 35);
        container.setBackground(Color.BLACK);
        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 3;

        constraints.insets = new Insets(0, 0, 10, 0);
        InputStream resourceAsStream = Swingy.class.getResourceAsStream("/images/chicken.jpg");
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
        container.add(classLabel, constraints);
        constraints.gridx = 6;
        constraints.gridy = 2;
        nameLabel.setText("NAME: " + hero.getName());
        nameLabel.setForeground(Color.white);
        constraints.anchor = LINE_START;
        nameLabel.setFont(font);
        container.add(nameLabel, constraints);
        constraints.gridx = 6;
        constraints.gridy = 3;
        xpLabel.setText("XP: " + hero.getXp());
        xpLabel.setForeground(Color.white);
        xpLabel.setFont(font);
        constraints.anchor = LINE_START;
        container.add(xpLabel, constraints);
        return container;
    }
}
