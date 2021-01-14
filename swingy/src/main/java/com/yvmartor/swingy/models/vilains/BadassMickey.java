package com.yvmartor.swingy.models.vilains;

import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.artefacts.ArtefactProvider;
import com.yvmartor.swingy.models.hero.Coordinates;
import com.yvmartor.swingy.models.hero.Hero;

public class BadassMickey extends VilainBuilder{
    private String name;
    private int attak;
    private Coordinates coordinates;
    private Artefact artefact;
    private String image;
    private Hero hero;

    public void buildName() {
        vilains.setName("Badass Mickey");
    }

    @Override
    public void buildHero(Hero hero) {
        vilains.setHero(hero);
    }

    @Override
    public void buildAttak() {
        vilains.setAttak(this.hero.getAttak() + 10);
    }

    @Override
    public void buildImage() {
        vilains.setImage("/images/big_boss_mickey.jpg");
    }

    @Override
    public void buildCoordinates() {
        vilains.setCoordinates(this.hero.getCoordinates());
    }

    @Override
    public void buildArtefact() {
        vilains.setArtefact(new ArtefactProvider(hero, "Badass Mickey").RandomArtefactProvider());
    }
}
