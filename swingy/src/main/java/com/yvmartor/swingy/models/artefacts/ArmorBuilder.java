package com.yvmartor.swingy.models.artefacts;

public class ArmorBuilder {
    String name;
    int points;
    String increasedStat;
    String image;

    public ArmorBuilder name(String name){
        this.name = name;
        return this;
    }

    public ArmorBuilder points(int points){
        this.points = points;
        return this;
    }

    public ArmorBuilder increasedStat(){
        this.increasedStat = "defense";
        return this;
    }

    public ArmorBuilder image(){
        this.image = "/images/armor.png";
        return this;
    }

    public Armor build(){
        Armor armor = new Armor(this);
        return armor;
    }
}
