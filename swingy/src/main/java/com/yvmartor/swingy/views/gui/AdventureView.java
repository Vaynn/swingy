package com.yvmartor.swingy.views.gui;

import javax.swing.*;
import java.util.ArrayList;

public class AdventureView extends JPanel{
    private ArrayList<JButton> action_buttons = new ArrayList<JButton>();
    private JLabel title = new JLabel();
    private JLabel ask = new JLabel();
    private JPanel hero_mini_card = new JPanel();
    private JPanel villain_mini_card = new JPanel();
    private JPanel lambda_card = new JPanel();
    private JLabel image = new JLabel();


    public ArrayList<JButton> getAction_buttons() {
        return action_buttons;
    }

    public JLabel getTitle() {
        return title;
    }

    public JLabel getAsk() {
        return ask;
    }

    public JPanel getHero_mini_card() {
        return hero_mini_card;
    }

    public JLabel getImage() {
        return image;
    }

    public JPanel getVillain_mini_card() {
        return villain_mini_card;
    }

    public JPanel getLambda_card() {
        return lambda_card;
    }

    public void setAction_buttons(ArrayList<JButton> action_buttons) {
        this.action_buttons = action_buttons;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public void setAsk(JLabel ask) {
        this.ask = ask;
    }

    public void setHero_mini_card(JPanel hero_mini_card) {
        this.hero_mini_card = hero_mini_card;
    }

    public void setImage(JLabel image) {
        this.image = image;
    }

    public void setVillain_mini_card(JPanel villain_mini_card) {
        this.villain_mini_card = villain_mini_card;
    }

    public void setLambda_card(JPanel lambda_card) {
        this.lambda_card = lambda_card;
    }
}
