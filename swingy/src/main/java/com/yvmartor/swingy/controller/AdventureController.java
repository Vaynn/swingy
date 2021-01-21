package com.yvmartor.swingy.controller;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.adventure.Adventure;
import com.yvmartor.swingy.models.scenario.fight_or_run.FightOrRun;
import com.yvmartor.swingy.models.scenario.fight_or_run.FightOrRunBuilder;
import com.yvmartor.swingy.models.scenario.question.Question;
import com.yvmartor.swingy.models.villains.Villain;
import com.yvmartor.swingy.views.console.ConsoleAdventureView;
import com.yvmartor.swingy.views.console.ConsoleFightOrRunView;

import java.util.ArrayList;
import java.util.Scanner;

import static com.yvmartor.swingy.models.tools.Tools.HERO_DEATH;
import static com.yvmartor.swingy.models.tools.Tools.VICTORY;

public class AdventureController {
    private Adventure model;
    private ConsoleAdventureView consoleView;
    private Scanner scanner;
    private int choice;

    public AdventureController(Adventure model, ConsoleAdventureView consoleView){
        this.model = model;
        this.consoleView = consoleView;
    }

    public void updateConsoleView() {
        Hero hero = model.getHero();
        WorldMap worldMap = model.getWorldMap();
        int destiny;

        while (true) {
            consoleView.printGameAdventure(hero, model.getOptions());
            //TODO Check user input
            scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            worldMap.updateHeroCoordinates(choice);
            Villain enemy = worldMap.isHeroMeetVilain(); //After the hero move , check if we meet an enemy
            if (enemy != null) {
                ArrayList<String> options = new ArrayList<String>();
                options.add("Fight");
                options.add("Run");
                String quest = "A " + enemy.getName() + " attacked you !\nWhat do you want to do ?";
                Question question = new Question(quest, options);
                FightOrRun fightOrRunModel = new FightOrRunBuilder()
                        .hero(hero)
                        .vilain(enemy)
                        .question(question)
                        .build();
                ConsoleFightOrRunView fightOrRunView = new ConsoleFightOrRunView();
                FightOrRunController controller = new FightOrRunController(fightOrRunModel, fightOrRunView);
                destiny = controller.updateConsoleView();
                if (destiny == HERO_DEATH){
                    break;
                }
            }
            if (worldMap.isHeroReachTheEdge() == true){
                destiny = VICTORY;
                break;
            }

        }
        if (destiny == HERO_DEATH){
            //TODO GAME OVER VIEW
            System.out.println("GAME OVER");
        }
        if (destiny == VICTORY){
            //TODO DB SAVE + ASK CONTINUE OR NOT.
            System.out.println("VICTORY");
        }
    }
}
