package com.yvmartor.swingy.models.scenario.select_hero;

import com.yvmartor.swingy.models.hero.Hero;


import java.util.ArrayList;

public class SelectHero {
    private String title;
    private ArrayList<Hero> heroesList;


    SelectHero(SelectHeroBuilder builder){
        this.title = builder.title;
        this.heroesList = builder.heroesList;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Hero> getHeroesList() {
        return heroesList;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setOptions(ArrayList<Hero> heroesList) {
        this.heroesList = heroesList;
    }

}
