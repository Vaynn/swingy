package com.yvmartor.swingy.models.villains;

import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.artefacts.ArtefactProvider;
import com.yvmartor.swingy.models.hero.Coordinates;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.tools.Tools;
import static com.yvmartor.swingy.models.tools.Tools.ADD;
import static com.yvmartor.swingy.models.tools.Tools.SUB;

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
        //random int define if we add or sub attack points
        int op = Tools.generateRandomInt(SUB, ADD);
        if (op == SUB) {
            //random int define how much points to add or sub
            int idx = Tools.generateRandomInt(10, 15);
            vilains.setAttak(heroAttak - idx);
        }
        else if (op == ADD) {
            //random int define how much points to add or sub
            int idx = Tools.generateRandomInt(0, 5);
            vilains.setAttak(heroAttak + idx);
        }

    }

    @Override
    public void buildDefense(int heroDefense) {
        //random int define if we add or sub attack points
        int op = Tools.generateRandomInt(SUB, ADD);
        if (op == SUB) {
            //random int define how much points to add or sub
            int idx = Tools.generateRandomInt(10, 15);
            vilains.setDefense(heroDefense - idx);
        }
        else if (op == ADD) {
            int idx = Tools.generateRandomInt(0, 5);
            vilains.setDefense(heroDefense + idx);
        }
    }

    @Override
    public void buildHitPoints(int heroHitPoints) {
        //random int define if we add or sub attack points
        int op = Tools.generateRandomInt(SUB, ADD);

        if (op == SUB) {
            //random int define how much points to add or sub
            int idx = Tools.generateRandomInt(10, 15);
            vilains.setHp(heroHitPoints - idx);
        }
        else if (op == ADD) {
            //random int define how much points to add or sub
            int idx = Tools.generateRandomInt(0, 5);
            vilains.setHp(heroHitPoints + idx);
        }

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
