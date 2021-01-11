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
    private JPanel center = new JPanel();
    private Font font = new Font("Courier", Font.ITALIC, 35);

    public HeroCard(Hero hero){
        this.hero = hero;
    }

    public void addStatLabel(JPanel container, String statName, String statValue){
        JLabel label = new JLabel();
        label.setText(statName + statValue);
        label.setForeground(Color.white);
        label.setFont(font);
        label.setBorder(new EmptyBorder(0, 10, 0, 0));
        container.add(label);
    }

    public JPanel getHeroCard() throws IOException{
        center.setLayout(new BoxLayout(center, BoxLayout.X_AXIS));
        center.setBackground(Color.BLACK);
        InputStream resourceAsStream = Swingy.class.getResourceAsStream(hero.getImage());
        try {
            Image image = ImageIO.read(resourceAsStream);
            JLabel label1 = new JLabel(new ImageIcon(image));

            center.add(label1);
        } catch (IOException e){
            System.err.println(e);
        }
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.BLACK);
        addStatLabel(container, "NAME: ",  hero.getName());
        addStatLabel(container, "CLASS: ",  hero.getHeroClass());
        addStatLabel(container, "LEVEL: ",  String.valueOf(hero.getLevel()));
        addStatLabel(container, "XP: ",  String.valueOf(hero.getXp()));
        addStatLabel(container, "ATTACK: ",  String.valueOf(hero.getAttak()));
        addStatLabel(container, "DEFENSE: ",  String.valueOf(hero.getDefense()));
        addStatLabel(container, "HP: ",  String.valueOf(hero.getHitPoints()));
        center.add(container);
        return center;
    }
}
