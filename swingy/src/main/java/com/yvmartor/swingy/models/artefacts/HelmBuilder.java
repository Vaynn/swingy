package com.yvmartor.swingy.models.artefacts;

public class HelmBuilder {
    String name;
    String material;
    int hitPoints;

    public HelmBuilder name(String name){
        this.name = name;
        return this;
    }

    public HelmBuilder material(String material){
        this.material = material;
        return this;
    }

    public HelmBuilder hitPoints(int hitPoints){
        this.hitPoints = HelmBuilder.this.hitPoints;
        return this;
    }

    public Helm build(){
        Helm helm = new Helm(this);
        return helm;
    }
}
