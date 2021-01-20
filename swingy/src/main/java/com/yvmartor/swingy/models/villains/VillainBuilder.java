package com.yvmartor.swingy.models.villains;

import com.yvmartor.swingy.models.hero.Hero;

public abstract class VillainBuilder {
    protected Villain vilains;

    public Villain getVilains(){
        return vilains;
    }

    public void createNewVilains(Hero hero){
        vilains = new Villain();
    }

    public abstract void buildName();
    public abstract void buildHero(Hero hero);
    public abstract void buildAttak(int heroAttak);
    public abstract void buildImage();
    public abstract void buildCoordinates();
    public abstract void buildArtefact(Hero hero);
    public abstract void buildDefense(int heroDefense);
    public abstract void buildHitPoints(int heroHitPoints);
    public abstract void buildWinXp();
}
