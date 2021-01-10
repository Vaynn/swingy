package com.yvmartor.swingy.models.hero;

import com.yvmartor.swingy.models.artefacts.*;

public class SaboteurBuilder extends HeroBuilder{
    @Override
    public void buildHeroClass() {
        hero.setHeroClass("Saboteur");
    }

    @Override
    public void buildName() {
        hero.setName("Looping");
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
        hero.setAttak(26);
    }

    @Override
    public void buildDefense() {
        hero.setDefense(25);
    }

    @Override
    public void buildHitPoints() {
        hero.setHitPoints(90);
    }

    @Override
    public void buildWeapon() {
        Weapon weapon = new WeaponBuilder()
                .name("Firecracker")
                .material("rusty")
                .attak(1)
                .build();
        hero.setWeapon(weapon);
    }

    @Override
    public void buildArmor() {
        Armor armor = new ArmorBuilder()
                .name("Rusty Chestplate")
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
        hero.setImage("/images/saboteur.jpg");
    }
}
