package com.yvmartor.swingy.models.scenario.game_over;

import com.yvmartor.swingy.models.map.WorldMap;

public class GameOver {
    private WorldMap worldMap;
    private String question;

    public GameOver(WorldMap worldMap, String question){
        this.worldMap = worldMap;
        this.question = question;
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
