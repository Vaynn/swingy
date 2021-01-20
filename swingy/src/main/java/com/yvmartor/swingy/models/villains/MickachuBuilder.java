package com.yvmartor.swingy.models.villains;

import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.artefacts.ArtefactProvider;
import com.yvmartor.swingy.models.hero.Coordinates;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.tools.Tools;

import static com.yvmartor.swingy.models.tools.Tools.ADD;
import static com.yvmartor.swingy.models.tools.Tools.SUB;

public class MickachuBuilder extends VillainBuilder {
    private String name;
    private int attak;
    private Coordinates coordinates;
    private Artefact artefact;
    private String image;
    private Hero hero;

    public void buildName() {
        vilains.setName("Mickachu");
    }

    @Override
    public void buildHero(Hero hero) {
        vilains.setHero(hero);
    }

    @Override
    public void buildAttak(int heroAttak) {
        //random int define if we add or sub attack points
        int op = Tools.generateRandomInt(SUB, ADD);
        //random int define how much points to add or sub
        int idx = Tools.generateRandomInt(5, 10);
        if (op == SUB)
            vilains.setAttak(heroAttak - idx);
        else if (op == ADD)
            vilains.setAttak(heroAttak + idx);
    }

    @Override
    public void buildDefense(int heroDefense) {
        //random int define if we add or sub attack points
        int op = Tools.generateRandomInt(SUB, ADD);
        //random int define how much points to add or sub
        int idx = Tools.generateRandomInt(5, 10);
        if (op == SUB)
            vilains.setDefense(heroDefense - idx);
        else if (op == ADD)
            vilains.setDefense(heroDefense + idx);
    }


    @Override
    public void buildHitPoints(int heroHitPoints) {
        //random int define if we add or sub attack points
        int op = Tools.generateRandomInt(SUB, ADD);
        //random int define how much points to add or sub
        int idx = Tools.generateRandomInt(5, 10);
        if (op == SUB)
            vilains.setHp(heroHitPoints - idx);
        else if (op == ADD)
            vilains.setHp(heroHitPoints + idx);
    }

    @Override
    public void buildWinXp() {
        vilains.setWinXp(250);
    }

    @Override
    public void buildImage() {
        vilains.setImage("/images/mickachu.jpg");
    }

    @Override
    public void buildCoordinates() {
        Coordinates coor = new Coordinates(0, 0);
        vilains.setCoordinates(coor);
    }

    @Override
    public void buildArtefact(Hero hero) {
        vilains.setArtefact(new ArtefactProvider(hero, "Mickachu").RandomArtefactProvider());
    }

}
