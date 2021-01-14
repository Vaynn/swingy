package com.yvmartor.swingy.models.vilains;

import com.yvmartor.swingy.models.hero.Hero;

public class VilainDirector {

    private VilainBuilder vilainsBuilder;

    public void setVilainsBuilder(VilainBuilder vilainsBuilder) {
        this.vilainsBuilder = vilainsBuilder;
    }

    public Vilain getVilains(){
        return vilainsBuilder.getVilains();
    }

    public void constructHero(Hero hero){
        vilainsBuilder.createNewVilains(hero);
        vilainsBuilder.buildName();
        vilainsBuilder.buildHero(hero);
        vilainsBuilder.buildAttak();
        vilainsBuilder.buildImage();
        vilainsBuilder.buildCoordinates();
    }
}
