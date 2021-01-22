package com.yvmartor.swingy.models.hero;

public class HeroDirector {
    private HeroBuilder heroBuilder;

    public void setHeroBuilder(HeroBuilder heroBuilder) {
        this.heroBuilder = heroBuilder;
    }

    public Hero getHero(){
        return heroBuilder.getHero();
    }

    public void constructHero(){
        heroBuilder.createNewHero();
        heroBuilder.buildHeroClass();
        heroBuilder.buildName();
        heroBuilder.buildXp();
        heroBuilder.buildLevel();
        heroBuilder.buildAttak();
        heroBuilder.buildDefense();
        heroBuilder.buildHitPoints();
        heroBuilder.buildWeapon();
        heroBuilder.buildArmor();
        heroBuilder.buildHelm();
        heroBuilder.buildImage();
        heroBuilder.buildGif();
        heroBuilder.buildCoordinates();
        heroBuilder.buildWeaponName();
        heroBuilder.buildArmorName();
        heroBuilder.buildHelmName();
    }

}
