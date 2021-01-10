package com.yvmartor.swingy.models.artefacts;

public class WeaponBuilder {
    String name;
    String material;
    int attak;

    public WeaponBuilder name(String name){
        this.name = name;
        return this;
    }

    public WeaponBuilder material(String material){
        this.material = material;
        return this;
    }

    public WeaponBuilder attak(int attak){
        this.attak = attak;
        return this;
    }

    public Weapon build(){
        Weapon weapon = new Weapon(this);
        return weapon;
    }
}
