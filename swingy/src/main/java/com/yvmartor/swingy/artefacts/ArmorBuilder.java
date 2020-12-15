package com.yvmartor.swingy.artefacts;

public class ArmorBuilder {
    String name;
    String material;
    int defense;

    public ArmorBuilder name(String name){
        this.name = name;
        return this;
    }

    public ArmorBuilder material(String material){
        this.material = material;
        return this;
    }

    public ArmorBuilder defense(int defense){
        this.defense = defense;
        return this;
    }

    public Armor build(){
        Armor armor = new Armor(this);
        return armor;
    }
}
