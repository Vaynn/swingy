package com.yvmartor.swingy.models.villains;

import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.hero.Coordinates;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;

public class Villain {
    private String name = null;
    private int attak = 0;
    private Coordinates coordinates = null;
    private Artefact artefact = null;
    private String image = null;
    private Hero hero;
    private WorldMap worldMap;

    public String getName() {
        return name;
    }

    public int getAttak() {
        return attak;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Artefact getArtefact() {
        return artefact;
    }

    public String getImage() {
        return image;
    }

    public Hero getHero() {
        return hero;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttak(int attak) {
        this.attak = attak;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setArtefact(Artefact artefact) {
        this.artefact = artefact;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void registerWorldMap(WorldMap worldMap){
        worldMap.registerVilain(this);
        this.worldMap = worldMap;
    }
}
