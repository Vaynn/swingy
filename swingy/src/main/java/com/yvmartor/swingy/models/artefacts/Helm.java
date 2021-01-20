package com.yvmartor.swingy.models.artefacts;

public class Helm extends Artefact {

    Helm(HelmBuilder builder){
        super(builder.name, builder.points);
        setIncreasedStat(builder.increasedStat);
    }

}
