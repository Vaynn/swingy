package com.yvmartor.swingy.models.artefacts;

public class Weapon {
    private final String name;
    private final String material;
    private final int attak;

    Weapon(WeaponBuilder builder){
        this.name = builder.name;
        this.material = builder.material;
        this.attak = builder.attak;
    }

    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public int getAttak() {
        return attak;
    }
}
