package com.yvmartor.swingy.models.scenario.direction;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;

public class Direction {
    private Hero hero;
    private WorldMap worldMap;
    private String[] options;

    public Direction(DirectionBuilder builder){
        this.hero = builder.hero;
        this.options = builder.options;
        this.worldMap = builder.worldMap;
    }

    public Hero getHero() {
        return hero;
    }

    public String[] getOptions() {
        return options;
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }
}
