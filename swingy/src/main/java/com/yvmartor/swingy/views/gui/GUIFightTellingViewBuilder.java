package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static com.yvmartor.swingy.models.tools.Tools.HERO_DEATH;
import static com.yvmartor.swingy.models.tools.Tools.VILLAIN_DEATH;

public class GUIFightTellingViewBuilder extends AdventureViewBuilder
{
    private Font font = new Font("Courier", Font.ITALIC, 20);
    private String[] continue_button = {"Continue"};
    private int winner;

    public GUIFightTellingViewBuilder(int winner){
        this.winner = winner;
    }

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
        for (int i = 0; i < continue_button.length; i++) {
            adventureView.getAction_buttons().add(new JButton(continue_button[i]));
        }

        //Continue
        c.gridx = 1;
        c.gridy = 1;
        actionButtons.add(adventureView.getAction_buttons().get(0), c);

        adventureView.add(actionButtons, BorderLayout.SOUTH);
    }

    @Override
    public void buildTitle() {
        if (winner == HERO_DEATH) {
            adventureView.getTitle().setText("LOOSER");
            adventureView.getTitle().setForeground(Color.RED);
        } else if (winner == VILLAIN_DEATH){
            adventureView.getTitle().setText("YOU WIN");
            adventureView.getTitle().setForeground(Color.CYAN);
        }
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
        if (winner == HERO_DEATH) {
            adventureView.setVillain_mini_card(new VillainCard(villain).getGameOverMiniCard());
            adventureView.getVillain_mini_card().setSize(100, 200);
            adventureView.add(adventureView.getVillain_mini_card(), BorderLayout.WEST);
        } else if (winner == VILLAIN_DEATH) {
            adventureView.setVillain_mini_card(new VillainCard(villain).getWinTheFightMiniCard());
            adventureView.getVillain_mini_card().setSize(100, 200);
            adventureView.add(adventureView.getVillain_mini_card(), BorderLayout.WEST);
        }
    }

    @Override
    public void buildImage() {

    }

    @Override
    public void buildLambdaCard() {
    }
}
