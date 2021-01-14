package com.yvmartor.swingy.models.scenario.adventure;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.scenario.game_opening.GameOpening;


import java.util.ArrayList;

public class AdventureBuilder {
    Hero hero;
    WorldMap worldMap;
    String[] options;

    public AdventureBuilder hero(Hero hero){
        this.hero = hero;
        return this;
    }

    public AdventureBuilder options(String[] options){
        this.options = options;
        return this;
    }

    public AdventureBuilder worldMap(WorldMap worldMap){
        this.worldMap = worldMap;
        return this;
    }

    public Adventure build(){
        Adventure adventure = new Adventure(this);
        return adventure;
    }
}
