package com.yvmartor.swingy.views.gui;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static com.yvmartor.swingy.models.tools.Tools.DIRECTIONS_TAB;
import static com.yvmartor.swingy.models.tools.Tools.GAME_OVER_TAB;

public class GUIGameOverViewBuilder extends AdventureViewBuilder
{
    private Font font = new Font("Courier", Font.ITALIC, 20);
    private String[] game_over_tab = GAME_OVER_TAB;
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
        for (int i = 0; i < game_over_tab.length; i++) {
            adventureView.getAction_buttons().add(new JButton(game_over_tab[i]));
        }
        //RETRY
        c.gridx = 0;
        c.gridy = 1;
        actionButtons.add(adventureView.getAction_buttons().get(0), c);

        //CHANGE HERO
        c.gridx = 1;
        c.gridy = 1;
        actionButtons.add(adventureView.getAction_buttons().get(1), c);

        //QUIT
        c.gridx = 2;
        c.gridy = 1;
        actionButtons.add(adventureView.getAction_buttons().get(2), c);

        adventureView.add(actionButtons, BorderLayout.SOUTH);

    }

    @Override
    public void buildTitle() {
        adventureView.getTitle().setText("GAME OVER");
        adventureView.getTitle().setForeground(Color.red);
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
        adventureView.setLambda_card(new LambdaCard().getLambdaCard("/images/game_over_view_right.jpg", "", ""));
        adventureView.getLambda_card().setSize(100, 200);
        adventureView.add(adventureView.getLambda_card(), BorderLayout.EAST);
    }

    @Override
    public void buildVillainMiniCard(Villain villain) {

    }

    @Override
    public void buildImage() {

    }

    @Override
    public void buildLambdaCard() {
        adventureView.setLambda_card(new LambdaCard().getLambdaCard("/images/game_over_left.jpg", "", ""));
        adventureView.getLambda_card().setSize(100, 200);
        adventureView.add(adventureView.getLambda_card(), BorderLayout.WEST);
    }
}
