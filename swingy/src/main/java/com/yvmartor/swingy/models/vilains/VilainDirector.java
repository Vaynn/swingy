package com.yvmartor.swingy.models.vilains;

import com.yvmartor.swingy.models.hero.Hero;

public class VilainDirector {

    private VilainBuilder vilainsBuilder;

    public void setVilainBuilder(VilainBuilder vilainsBuilder) {
        this.vilainsBuilder = vilainsBuilder;
    }

    public Vilain getVilain(){
        return vilainsBuilder.getVilains();
    }

    public void constructVilain(Hero hero){
        vilainsBuilder.createNewVilains(hero);
        vilainsBuilder.buildName();
        vilainsBuilder.buildHero(hero);
        vilainsBuilder.buildAttak(hero.getAttak());
        vilainsBuilder.buildImage();
        vilainsBuilder.buildCoordinates();
        vilainsBuilder.buildArtefact(hero);
    }
}
