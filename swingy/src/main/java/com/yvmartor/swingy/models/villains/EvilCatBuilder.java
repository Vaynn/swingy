package com.yvmartor.swingy.models.villains;

import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.artefacts.ArtefactProvider;
import com.yvmartor.swingy.models.hero.Coordinates;
import com.yvmartor.swingy.models.hero.Hero;

public class EvilCatBuilder extends VillainBuilder {
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
    public void buildAttak(int heroAttak) {
        vilains.setAttak(heroAttak - 5);

    }

    @Override
    public void buildImage() {
        vilains.setImage("/images/evil_cat.jpg");
    }

    @Override
    public void buildCoordinates() {
        Coordinates coor = new Coordinates(0, 0);
        vilains.setCoordinates(coor);

    }

    @Override
    public void buildArtefact(Hero hero) {
        vilains.setArtefact(new ArtefactProvider(hero, "Evil Cat").RandomArtefactProvider());
    }
}
