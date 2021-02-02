package com.yvmartor.swingy;

import com.yvmartor.swingy.controller.GameOpeningController;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;
import com.yvmartor.swingy.models.scenario.game_opening.GameOpening;
import com.yvmartor.swingy.models.scenario.game_opening.GameOpeningBuilder;
import com.yvmartor.swingy.views.console.ConsoleGameOpeningView;
import com.yvmartor.swingy.views.gui.GUIGameOpeningView;

import java.io.IOException;
import java.util.ArrayList;

public class Swingy {


    public static void main(String[] args) {
        if (args.length == 1){
            String mode = args[0];
            if (mode.compareTo("console") == 0 || mode.compareTo("gui") == 0) {

                //Start the menu of the game
                ArrayList<String> options = new ArrayList<String>();
                options.add("1)" + " Play with a new hero\n");
                options.add("2)" + " Select one of your hero\n");
                GameOpening gameOpeningModel = new GameOpeningBuilder()
                        .title("\nWelcome to Swingy\n")
                        .options(options)
                        .image("/images/landscape.jpg")
                        .build();
                if (mode.compareTo("console") == 0) {
                    ConsoleGameOpeningView consoleGameOpeningView = new ConsoleGameOpeningView();
                    GameOpeningController controller = new GameOpeningController(
                            gameOpeningModel,
                            consoleGameOpeningView,
                            null);
                    try {
                        controller.updateView();
                    } catch (IOException e) {
                        ConsoleStringColor.error(
                                "AN ERROR OCCURED, GAME OPENING VIEW CAN'T BE DISPLAY. " +
                                        "FORGIVENESS FOR THE DESAGREMENT GENERATED");
                        System.exit(-1);
                    }
                }
                else if (mode.compareTo("gui") == 0) {
                    GUIGameOpeningView guiGameOpeningView = new GUIGameOpeningView();
                    GameOpeningController controller = new GameOpeningController(
                            gameOpeningModel,
                            null,
                            guiGameOpeningView);
                    try {
                        controller.updateView();
                    } catch (IOException e) {
                        ConsoleStringColor.error(
                                "AN ERROR OCCURED, GAME OPENING VIEW CAN'T BE DISPLAY. " +
                                        "FORGIVENESS FOR THE DESAGREMENT GENERATED");
                        System.exit(-1);
                    }
                }
                else
                    ConsoleStringColor.error("To play, you must choose between two mode : \n\tconsole \n\tgui");
            }
            else
                ConsoleStringColor.error("To play, you must choose between two mode : \n\tconsole \n\tgui");
        }
        else
            ConsoleStringColor.error("To play, you must choose between two mode : \n\tconsole \n\tgui");
    }
}
