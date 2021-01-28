package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIFightOrRunViewBuilder extends AdventureViewBuilder {

    private Font font = new Font("Courier", Font.ITALIC, 20);
    private String[] duel_choice = {"Fight", "Run"};

    @Override
    public void buildContainer() {
        adventureView.setLayout(new BorderLayout(5, 5));
        adventureView.setBackground(Color.BLACK);
        adventureView.setBorder(new EmptyBorder(0, 0, 300, 0));
    }

    @Override
    public void buildActionButtons() {
        JPanel actionButtons = new JPanel(new GridBagLayout());
        actionButtons.setBackground(Color.BLACK);
        actionButtons.setSize(100,100);
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < duel_choice.length; i++) {
            adventureView.getAction_buttons().add(new JButton(duel_choice[i]));
        }
        //FIGHT
        c.gridx = 2;
        c.gridy = 1;
        actionButtons.add(adventureView.getAction_buttons().get(1), c);

        //RUN
        c.gridx = 0;
        c.gridy = 1;
        actionButtons.add(adventureView.getAction_buttons().get(0), c);

        adventureView.add(actionButtons, BorderLayout.SOUTH);
    }

    @Override
    public void buildTitle() {
        adventureView.getTitle().setText("Try to get out the labyrinth.");
        adventureView.getTitle().setForeground(Color.cyan);
        adventureView.getTitle().setFont(font);
        adventureView.getTitle().setHorizontalAlignment(JLabel.CENTER);
        adventureView.getTitle().setVerticalAlignment(JLabel.CENTER);
        adventureView.getTitle().setBorder(new EmptyBorder(20, 0, 50, 0));
        adventureView.add(adventureView.getTitle(), BorderLayout.NORTH);
    }

    @Override
    public void buildAsk(String ask) {
        adventureView.getAsk().setText(ask);
        adventureView.getAsk().setBorder(new EmptyBorder(200,280,0,0));
        adventureView.getAsk().setForeground(Color.green);
        adventureView.getAsk().setHorizontalAlignment(JLabel.CENTER);
        adventureView.getAsk().setVerticalAlignment(JLabel.CENTER);
        adventureView.add(adventureView.getAsk(), BorderLayout.CENTER);
    }

    @Override
    public void buildHeroMiniCard(WorldMap worldMap) {
        adventureView.setHero_mini_card(new HeroCard(worldMap.getHero()).getHeroMiniCard());
        adventureView.getHero_mini_card().setSize(100, 200);
        adventureView.add(adventureView.getHero_mini_card(), BorderLayout.EAST);
    }

    @Override
    public void buildVillainMiniCard(Villain villain) {
        adventureView.setVillain_mini_card(new VillainCard(villain));
        adventureView.getVillain_mini_card().setSize(100, 200);
        adventureView.add(adventureView.getVillain_mini_card(), BorderLayout.WEST);
    }

    @Override
    public void buildImage() {

    }
}
