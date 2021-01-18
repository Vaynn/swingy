package com.yvmartor.swingy.models.villains;

import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.artefacts.ArtefactProvider;
import com.yvmartor.swingy.models.hero.Coordinates;
import com.yvmartor.swingy.models.hero.Hero;

public class BadassMickey extends VillainBuilder {
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
    public void buildAttak(int heroAttak) {
        vilains.setAttak(heroAttak + 10);
    }

    @Override
    public void buildImage() {
        vilains.setImage("/images/big_boss_mickey.jpg");
    }

    @Override
    public void buildCoordinates() {
        Coordinates coor = new Coordinates(0, 0);
        vilains.setCoordinates(coor);
    }

    @Override
    public void buildArtefact(Hero hero) {
        vilains.setArtefact(new ArtefactProvider(hero, "Badass Mickey").RandomArtefactProvider());
    }
}
