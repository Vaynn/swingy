package com.yvmartor.swingy.models.villains;

import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.hero.Coordinates;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.map.WorldMap;

import static com.yvmartor.swingy.models.tools.Tools.HERO_DEATH;
import static com.yvmartor.swingy.models.tools.Tools.VILLAIN_DEATH;

public class Villain {
    private String name = null;
    private int idx = 0;
    private int attak = 0;
    private int defense = 0;
    private int hp = 0;
    private int winXp = 0;
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

    public int getDefense() {
        return defense;
    }

    public int getHp() {
        return hp;
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

    public int getIdx() {
        return idx;
    }

    public int getWinXp() {
        return winXp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAttak(int attak) {
        this.attak = attak;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void setWinXp(int winXp) {
        this.winXp = winXp;
    }

    public void registerWorldMap(WorldMap worldMap){
        worldMap.registerVilain(this);
        this.worldMap = worldMap;
    }

    //Fight one round with the Villain, return the remains HP of the villain
    public int underAttack(int myHP){
        int heroAttack = hero.getAttak();
        int myDefense = getDefense();
        if (myDefense >= heroAttack)
            myHP -= 1;
        else{
            myHP -= heroAttack - myDefense;
        }
        if (myHP <= 0)
            myHP = VILLAIN_DEATH;
        return myHP;
    }
}
