package com.yvmartor.swingy.models.artefacts;

public class Armor extends Artefact{


    Armor(ArmorBuilder builder){
        super(builder.name, builder.points);
    }
}
