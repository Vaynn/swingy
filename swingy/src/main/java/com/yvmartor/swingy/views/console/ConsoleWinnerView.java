package com.yvmartor.swingy.views.console;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;

import static com.yvmartor.swingy.models.tools.Tools.WINNER_TAB;

public class ConsoleWinnerView {

    public void printWinnerView(WorldMap worldMap, String question){
        ConsoleStringColor.story(question);
        int indice;
        for (int i = 0; i < WINNER_TAB.length; i++){
            indice = i + 1;
            ConsoleStringColor.action("\t" + indice + ") " + WINNER_TAB[i] + "\n");
        }
    }
}
