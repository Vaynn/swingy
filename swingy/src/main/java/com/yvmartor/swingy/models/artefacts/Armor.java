package com.yvmartor.swingy.models.artefacts;

public class Armor {
    private String name;
    private String material;
    private int defense;

    Armor(ArmorBuilder builder){
        this.name = builder.name;
        this.material = builder.material;
        this.defense = builder.defense;
    }

    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public int getDefense() {
        return defense;
    }
}
