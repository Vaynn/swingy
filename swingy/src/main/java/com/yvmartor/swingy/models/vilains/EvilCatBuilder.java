package com.yvmartor.swingy.models.vilains;

import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.artefacts.ArtefactProvider;
import com.yvmartor.swingy.models.hero.Coordinates;
import com.yvmartor.swingy.models.hero.Hero;

public class EvilCatBuilder extends VilainBuilder{
    private String name;
    private int attak;
    private Coordinates coordinates;
    private Artefact artefact;
    private String image;
    private Hero hero;

    public void buildName() {
        vilains.setName("Evil Cat");
    }

    @Override
    public void buildHero(Hero hero) {
        vilains.setHero(hero);
    }

    @Override
    public void buildAttak() {
        vilains.setAttak(this.hero.getAttak() - 5);

    }

    @Override
    public void buildImage() {
        vilains.setImage("/images/evil_cat.jpg");
    }

    @Override
    public void buildCoordinates() {
        vilains.setCoordinates(this.hero.getCoordinates());

    }

    @Override
    public void buildArtefact() {
        vilains.setArtefact(new ArtefactProvider(hero, "Evil Cat").RandomArtefactProvider());
    }
}
