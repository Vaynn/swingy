package com.yvmartor.swingy.models.hero;

public abstract class HeroBuilder {

    protected Hero hero;

    public Hero getHero(){
        return hero;
    }

    public void createNewHero(){
        hero = new Hero();
    }

    public abstract void buildHeroClass();
    public abstract void buildName();
    public abstract void buildXp();
    public abstract void buildLevel();
    public abstract void buildAttak();
    public abstract void buildDefense();
    public abstract void buildHitPoints();
    public abstract void buildWeapon();
    public abstract void buildArmor();
    public abstract void buildHelm();
    public abstract void buildImage();
    public abstract void buildCoordinates();
    public abstract void buildWeaponName();
    public abstract void buildArmorName();
    public abstract void buildHelmName();

}
