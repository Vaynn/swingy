package com.yvmartor.swingy.models.hero;

import com.yvmartor.swingy.artefacts.*;

public class BlackKnightBuilder extends HeroBuilder {
    @Override
    public void buildHeroClass() {
        hero.setHeroClass("Black Knight");
    }

    @Override
    public void buildName() {
        hero.setName("Robert");
    }

    @Override
    public void buildXp() {
        hero.setXp(850);
    }

    @Override
    public void buildLevel() {
        hero.setLevel(1);
    }

    @Override
    public void buildAttak() {
        hero.setAttak(25);
    }

    @Override
    public void buildDefense() {
        hero.setDefense(20);
    }

    @Override
    public void buildHitPoints() {
        hero.setHitPoints(80);
    }

    @Override
    public void buildWeapon() {
        Weapon weapon = new WeaponBuilder()
                .name("Rusty Sword")
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
        hero.setImage("/images/black_knight.jpg");
    }
}
