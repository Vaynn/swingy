package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.scenario.game_opening.GameOpening;
import com.yvmartor.swingy.models.scenario.select_hero.SelectHero;
import com.yvmartor.swingy.views.console.ConsoleSelectHeroView;
import com.yvmartor.swingy.views.gui.GUISelectHeroView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

public class SelectHeroController {
    private SelectHero model;
    private ConsoleSelectHeroView consoleView;
    private GUISelectHeroView gUIView;
    private Scanner userChoice;
    private int choice;
    private JFrame frame;

    public SelectHeroController(SelectHero model, JFrame frame, ConsoleSelectHeroView consoleView, GUISelectHeroView gUIView){
        this.model = model;
        this.consoleView = consoleView;
        this.gUIView = gUIView;
        this.frame = frame;
    }

    public void updateConsoleView(){
        consoleView.printSelectHeroView(model.getTitle(), model.getHeroesList());
        userChoice = new Scanner(System.in);
        choice = userChoice.nextInt();
        System.out.println(model.getHeroesList().get(choice - 1).getName());

    }

    public void updateGUIView() throws IOException {
        gUIView.printSelectHeroView(frame, model.getTitle(), model.getHeroesList());
        gUIView.getSelection().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int heroIdx = gUIView.getHeroTab().getSelectedIndex();
                System.out.println(heroIdx);
                System.out.println(model.getHeroesList().get(heroIdx).getName());
            }
        });
    }
}
