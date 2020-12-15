package com.yvmartor.swingy.models.hero;

import com.yvmartor.swingy.artefacts.*;

public class MadKnightBuilder extends HeroBuilder{
    @Override
    public void buildHeroClass() {
        hero.setHeroClass("Mad Knight");
    }

    @Override
    public void buildName() {
        hero.setName("Godrik");
    }

    @Override
    public void buildXp() {
        hero.setXp(1000);
    }

    @Override
    public void buildLevel() {
        hero.setLevel(1);
    }

    @Override
    public void buildAttak() {
        hero.setAttak(20);
    }

    @Override
    public void buildDefense() {
        hero.setDefense(25);
    }

    @Override
    public void buildHitPoints() {
        hero.setHitPoints(85);
    }

    @Override
    public void buildWeapon() {
        Weapon weapon = new WeaponBuilder()
                .name("Rusty Spear")
                .material("rusty")
                .attak(1)
                .build();
        hero.setWeapon(weapon);
    }

    @Override
    public void buildArmor() {
        Armor armor = new ArmorBuilder()
                .name("Rusty Armor")
                .material("rusty")
                .defense(1)
                .build();
        hero.setArmor(armor);
    }

    @Override
    public void buildHelm() {
        Helm helm = new HelmBuilder()
                .name("Rusty Helm")
                .material("rusty")
                .hitPoints(1)
                .build();
        hero.setHelm(helm);
    }

    @Override
    public void buildImage() {
        hero.setImage("/images/chevalier.jpg");
    }
}
