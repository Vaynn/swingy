package com.yvmartor.swingy.models.artefacts;

public abstract class Artefact {
    private String name;
    private int points;
    private String image = "";
    private String increasedStat = "";

    public Artefact(String name, int points){
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getImage() {
        return image;
    }

    public String getIncreasedStat() {
        return increasedStat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIncreasedStat(String increasedStat) {
        this.increasedStat = increasedStat;
    }
}
