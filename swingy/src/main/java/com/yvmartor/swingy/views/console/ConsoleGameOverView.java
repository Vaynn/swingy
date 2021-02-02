package com.yvmartor.swingy.views.console;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;
import com.yvmartor.swingy.models.scenario.question.Question;
import com.yvmartor.swingy.models.tools.Tools;

import java.util.ArrayList;

import static com.yvmartor.swingy.models.tools.Tools.GAME_OVER_TAB;

public class ConsoleGameOverView {
    public void printGameOver(WorldMap worldMap, String question){
        ConsoleStringColor.story(question);
        int indice;
        for (int i = 0; i < GAME_OVER_TAB.length; i++){
            indice = i + 1;
            ConsoleStringColor.action("\t" + indice + ") " + GAME_OVER_TAB[i] + "\n");
        }
    }
}
