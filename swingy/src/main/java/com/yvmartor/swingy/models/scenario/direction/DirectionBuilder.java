package com.yvmartor.swingy.models.scenario.direction;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;

public class DirectionBuilder {
    Hero hero;
    WorldMap worldMap;
    String[] options;


    public DirectionBuilder hero(Hero hero){
        this.hero = hero;
        return this;
    }

    public DirectionBuilder options(String[] options){
        this.options = options;
        return this;
    }

    public DirectionBuilder worldMap(WorldMap worldMap){
        this.worldMap = worldMap;
        return this;
    }

    public Direction build(){
        Direction direction = new Direction(this);
        return direction;
    }
}
