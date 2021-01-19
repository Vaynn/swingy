package com.yvmartor.swingy.models.villains;

import com.yvmartor.swingy.models.hero.Hero;

public class VillainDirector {

    private VillainBuilder vilainsBuilder;

    public void setVilainBuilder(VillainBuilder vilainsBuilder) {
        this.vilainsBuilder = vilainsBuilder;
    }

    public Villain getVilain(){
        return vilainsBuilder.getVilains();
    }

    public void constructVilain(Hero hero){
        vilainsBuilder.createNewVilains(hero);
        vilainsBuilder.buildName();
        vilainsBuilder.buildHero(hero);
        vilainsBuilder.buildAttak(hero.getAttak());
        vilainsBuilder.buildDefense(hero.getDefense());
        vilainsBuilder.buildHitPoints(hero.getHitPoints());
        vilainsBuilder.buildImage();
        vilainsBuilder.buildCoordinates();
        vilainsBuilder.buildArtefact(hero);
    }
}
