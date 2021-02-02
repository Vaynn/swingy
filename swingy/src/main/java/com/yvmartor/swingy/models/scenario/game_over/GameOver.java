package com.yvmartor.swingy.models.scenario.game_over;

import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.question.Question;

import java.util.ArrayList;

public class GameOver {
    private WorldMap worldMap;
    private String question;

    public GameOver(WorldMap worldMap){
        this.worldMap = worldMap;
        this.question = "GAME OVER!\n What do you want to do ?\n";
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public String getQuestion() {
        return question;
    }

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }
}
