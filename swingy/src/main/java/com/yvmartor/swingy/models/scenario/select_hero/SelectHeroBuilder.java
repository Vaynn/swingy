package com.yvmartor.swingy.models.scenario.select_hero;

import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.scenario.game_opening.GameOpening;
import com.yvmartor.swingy.models.scenario.game_opening.GameOpeningBuilder;

import java.util.ArrayList;

public class SelectHeroBuilder {
    String title;
    ArrayList<Hero> heroesList;

    public SelectHeroBuilder title(String title){
        this.title = title;
        return this;
    }

    public SelectHeroBuilder heroesList(ArrayList<Hero> heroesList){
        this.heroesList = heroesList;
        return this;
    }

    public SelectHero build(){
        SelectHero selectHero = new SelectHero(this);
        return selectHero;
    }
}
