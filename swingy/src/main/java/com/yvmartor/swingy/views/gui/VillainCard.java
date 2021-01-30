package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.Swingy;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.villains.Villain;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class VillainCard extends JPanel {
    private Villain villain;
    private JPanel container = new JPanel();
    private Font fontmini = new Font("Courier", Font.PLAIN, 15);

    public VillainCard(Villain villain){
        this.villain = villain;
    }

    public void addStatLabel(JPanel container, Font font, String statName, String statValue){
        JLabel label = new JLabel();
        label.setText(statName + statValue);
        label.setForeground(Color.white);
        label.setFont(font);
        label.setBorder(new EmptyBorder(0, 10, 0, 0));
        container.add(label);
    }

    public JPanel getVillainMiniCard(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.BLACK);
        InputStream resourceAsStream = Swingy.class.getResourceAsStream(villain.getImage());
        try {
            Image image = ImageIO.read(resourceAsStream);
            JLabel label1 = new JLabel(new ImageIcon(image));

            this.add(label1);
        } catch (IOException e){
            System.err.println(e);
        }
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.BLACK);
        addStatLabel(container, fontmini, "VILLAIN ",  villain.getName());
        addStatLabel(container, fontmini, "HP ",  String.valueOf(villain.getHp()));
        addStatLabel(container, fontmini, "ATK ",
                String.valueOf(villain.getAttak()));
        addStatLabel(container, fontmini, "DEF ",
                String.valueOf(villain.getDefense()));
        this.add(container);
        return this;
    }

    public JPanel getGameOverMiniCard(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.BLACK);
        InputStream resourceAsStream = Swingy.class.getResourceAsStream("/images/game_over_skull.jpg");
        try {
            Image image = ImageIO.read(resourceAsStream);
            JLabel label1 = new JLabel(new ImageIcon(image));

            this.add(label1);
        } catch (IOException e){
            System.err.println(e);
        }
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.BLACK);
        addStatLabel(container, fontmini, "WINNER ",  villain.getName());
        addStatLabel(container, fontmini, "LOOSER ", "you");
        this.add(container);
        return this;
    }

    public JPanel getWinTheFightMiniCard(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.BLACK);
        InputStream resourceAsStream = Swingy.class.getResourceAsStream("/images/win_the_fight.jpg");
        try {
            Image image = ImageIO.read(resourceAsStream);
            JLabel label1 = new JLabel(new ImageIcon(image));

            this.add(label1);
        } catch (IOException e){
            System.err.println(e);
        }
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.BLACK);
        addStatLabel(container, fontmini, "YOU WIN ",  "THE FIGHT !");
        this.add(container);
        return this;
    }

    public JPanel getArtefactMiniCard(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.BLACK);
        InputStream resourceAsStream = Swingy.class.getResourceAsStream(villain.getArtefact().getImage());
        try {
            Image image = ImageIO.read(resourceAsStream);
            JLabel label1 = new JLabel(new ImageIcon(image));

            this.add(label1);
        } catch (IOException e){
            System.err.println(e);
        }
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(Color.BLACK);
        addStatLabel(container, fontmini, "<html>New " + villain.getArtefact().getClass().getSimpleName() + " Available:<br>",  villain.getArtefact().getName() + "</html>");
        this.add(container);
        return this;
    }
}
