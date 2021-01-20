package com.yvmartor.swingy.models.artefacts;

public class HelmBuilder {
    String name;
    int points;
    String increasedStat;

    public HelmBuilder name(String name){
        this.name = name;
        return this;
    }

    public HelmBuilder points(int points){
        this.points = points;
        return this;
    }

    public HelmBuilder increasedStat(){
        this.increasedStat = "hit points";
        return this;
    }

    public Helm build(){
        Helm helm = new Helm(this);
        return helm;
    }
}
