package com.yvmartor.swingy.models.artefacts;

public class Weapon extends Artefact{

    Weapon(WeaponBuilder builder){
        super(builder.name, builder.points);
        setIncreasedStat(builder.increasedStat);
    }

}
