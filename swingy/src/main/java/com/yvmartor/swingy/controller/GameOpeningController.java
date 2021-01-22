package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.hero.HeroListBuilder;
import com.yvmartor.swingy.models.scenario.game_opening.GameOpening;
import com.yvmartor.swingy.models.scenario.select_hero.SelectHero;
import com.yvmartor.swingy.models.scenario.select_hero.SelectHeroBuilder;
import com.yvmartor.swingy.views.console.ConsoleGameOpeningView;
import com.yvmartor.swingy.views.console.ConsoleSelectHeroView;
import com.yvmartor.swingy.views.gui.CreateMainFrame;
import com.yvmartor.swingy.views.gui.GUIGameOpeningView;
import com.yvmartor.swingy.views.gui.GUISelectHeroView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameOpeningController {
    private GameOpening model;
    private ConsoleGameOpeningView consoleView;
    private GUIGameOpeningView gUIView;
    private Scanner userChoice;

    private int choice;


    public GameOpeningController(GameOpening model, ConsoleGameOpeningView consoleView, GUIGameOpeningView gUIView){
        this.model = model;
        this.consoleView = consoleView;
        this.gUIView = gUIView;
    }

    public void setGameOpeningTitle(String title){
        model.setTitle(title);
    }

    public String getGameOpeningTitle(){
        return model.getTitle();
    }

    public void setGameOpeningOptions(ArrayList<String> options){
        model.setOptions(options);
    }

    public ArrayList<String> getGameOpeningOptions(){
        return model.getOptions();
    }

    public void updateConsoleView(){
        consoleView.printGameOpening(model.getTitle(), model.getOptions());
        //TODO Check user input
        userChoice = new Scanner(System.in);
        choice = userChoice.nextInt();
        if (choice == 1) {
            ArrayList<Hero> heroList = new HeroListBuilder().heroListBuilder();
            SelectHero selectHeroModel = getSelectHeroModel(heroList);
            ConsoleSelectHeroView consoleSelectHeroView = new ConsoleSelectHeroView();
            SelectHeroController controller = new SelectHeroController(
                    selectHeroModel,
                    null, consoleSelectHeroView,
                    null
            );
            controller.updateConsoleView();
        }
        else if (choice == 2)
            System.out.println("a=2");
        else
            System.out.println("Errror");
    }

    public void updateGUIView() throws IOException {
        CreateMainFrame frame = new CreateMainFrame();
        JFrame myFrame = frame.getMyFrame();
        gUIView.printGameOpening(myFrame, model.getTitle(), model.getOptions(), model.getImage());
        myFrame.setVisible(true);
        gUIView.getNewHero().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Hero> heroList = new HeroListBuilder().heroListBuilder();
                SelectHero selectHeroModel = getSelectHeroModel(heroList);
                GUISelectHeroView guiSelectHeroView = new GUISelectHeroView();
                SelectHeroController controller = new SelectHeroController(selectHeroModel, myFrame, null, guiSelectHeroView);
                try {
                    controller.updateGUIView();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }

    public void updateView() throws IOException {
        if (this.gUIView != null && this.consoleView == null)
            updateGUIView();
        else if (this.consoleView != null && this.gUIView == null)
            updateConsoleView();
    }

    private SelectHero getSelectHeroModel(ArrayList<Hero> heroList){
        SelectHero selectHeroModel = new SelectHeroBuilder()
                .title("\nSelect your Hero\n")
                .heroesList(heroList)
                .build();
        return selectHeroModel;
    }

}
