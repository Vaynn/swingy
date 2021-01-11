package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.scenario.game_opening.GameOpening;
import com.yvmartor.swingy.models.scenario.select_hero.SelectHero;
import com.yvmartor.swingy.views.console.ConsoleSelectHeroView;
import com.yvmartor.swingy.views.gui.GUISelectHeroView;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class SelectHeroController {
    private SelectHero model;
    private ConsoleSelectHeroView consoleView;
    private GUISelectHeroView gUIView;
    private Scanner userChoice;
    private JFrame frame;

    public SelectHeroController(SelectHero model, JFrame frame, ConsoleSelectHeroView consoleView, GUISelectHeroView gUIView){
        this.model = model;
        this.consoleView = consoleView;
        this.gUIView = gUIView;
        this.frame = frame;
    }

    public void updateConsoleView(){
        consoleView.printSelectHeroView(model.getTitle(), model.getHeroesList());
    }

    public void updateGUIView() throws IOException {
        gUIView.printSelectHeroView(frame, model.getTitle(), model.getHeroesList());
        gUIView.getSelection.add
    }
}
