package com.yvmartor.swingy.models.map;

import com.yvmartor.swingy.models.hero.Hero;

import java.util.ArrayList;

import static java.lang.Math.round;

public class WorldMap {

    private int dimension;
    private Hero hero;

    public void registerHero(Hero hero){
        this.hero = hero;
        mapDimensionProvider();
        this.hero.getCoordinates().setX((int)round((double)dimension/2));
        this.hero.getCoordinates().setY((int)round((double)dimension/2));
    }

    private void mapDimensionProvider(){
        this.dimension = (this.hero.getLevel() - 1) * 5 + 10 - 1;
        System.out.println(this.dimension);
    }

    public void updateHeroCoordinates(int userChoice){
        this.hero.updateCoordinates(userChoice);
    }
}
