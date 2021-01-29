package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIDirectionViewBuilder extends AdventureViewBuilder {

    private Font font = new Font("Courier", Font.ITALIC, 20);
    private String[] direction = {"Go to the North", "Go to the East", "Go to the South", "Go to the West"};

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
        for (int i = 0; i < direction.length; i++) {
            adventureView.getAction_buttons().add(new JButton(direction[i]));
        }
        //NORTH
        c.gridx = 1;
        c.gridy = 0;
        actionButtons.add(adventureView.getAction_buttons().get(0), c);

        //EAST
        c.gridx = 2;
        c.gridy = 1;
        actionButtons.add(adventureView.getAction_buttons().get(1), c);

        //SOUTH
        c.gridx = 1;
        c.gridy = 2;
        actionButtons.add(adventureView.getAction_buttons().get(2), c);

        //WEST
        c.gridx = 0;
        c.gridy = 1;
        actionButtons.add(adventureView.getAction_buttons().get(3), c);

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
        adventureView.getAsk().setForeground(Color.green);
        adventureView.getAsk().setHorizontalAlignment(JLabel.CENTER);
        adventureView.getAsk().setVerticalAlignment(JLabel.CENTER);
        JScrollPane scrollPane = new JScrollPane(adventureView.getAsk());
        scrollPane.getViewport().setBackground(Color.DARK_GRAY);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        adventureView.add(scrollPane, BorderLayout.CENTER);

    }

    @Override
    public void buildHeroMiniCard(WorldMap worldMap) {
        adventureView.setHero_mini_card(new HeroCard(worldMap.getHero()).getHeroMiniCard());
        adventureView.getHero_mini_card().setSize(100, 200);
        adventureView.add(adventureView.getHero_mini_card(), BorderLayout.EAST);
    }

    @Override
    public void buildVillainMiniCard(Villain villain) {

    }

    @Override
    public void buildImage() {

    }

    @Override
    public void buildLambdaCard() {
        adventureView.setLambda_card(LambdaCard.getLambdaCard("/images/labyrinth.jpg", "Walk through ", "labyrinth"));
        adventureView.getLambda_card().setSize(100, 200);
        adventureView.add(adventureView.getLambda_card(), BorderLayout.WEST);
    }
}
