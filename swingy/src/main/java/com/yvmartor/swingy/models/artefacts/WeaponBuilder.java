package com.yvmartor.swingy.models.artefacts;

public class WeaponBuilder {
    public String image;
    String name;
    int points;
    String increasedStat;

    public WeaponBuilder name(String name){
        this.name = name;
        return this;
    }

    public WeaponBuilder points(int points){
        this.points = points;
        return this;
    }

    public WeaponBuilder increasedStat(){
        this.increasedStat = "attack";
        return this;
    }

    public WeaponBuilder image(){
        this.image = "/images/weapon.png";
        return this;
    }

    public Weapon build(){
        Weapon weapon = new Weapon(this);
        return weapon;
    }
}
