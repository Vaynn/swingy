package com.yvmartor.swingy.models.vilains;

import com.yvmartor.swingy.models.hero.Hero;

public abstract class VilainBuilder {
    protected Vilain vilains;

    public Vilain getVilains(){
        return vilains;
    }

    public void createNewVilains(Hero hero){
        vilains = new Vilain();
    }

    public abstract void buildName();
    public abstract void buildHero(Hero hero);
    public abstract void buildAttak();
    public abstract void buildImage();
    public abstract void buildCoordinates();
    public abstract void buildArtefact();
}
