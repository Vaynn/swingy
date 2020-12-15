package com.yvmartor.swingy.artefacts;

public class Helm {
    private String name;
    private String material;
    private int hitPoints;

    Helm(HelmBuilder builder){
        this.name = builder.name;
        this.material = builder.material;
        this.hitPoints = builder.hitPoints;
    }

    public String getName() {
        return name;
    }

    public String getMaterial() {
        return material;
    }

    public int getHitPoints() {
        return hitPoints;
    }
}
