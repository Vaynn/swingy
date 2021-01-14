package com.yvmartor.swingy.models.artefacts;

public class ArmorBuilder {
    String name;
    int points;

    public ArmorBuilder name(String name){
        this.name = name;
        return this;
    }

    public ArmorBuilder points(int points){
        this.points = points;
        return this;
    }

    public Armor build(){
        Armor armor = new Armor(this);
        return armor;
    }
}
