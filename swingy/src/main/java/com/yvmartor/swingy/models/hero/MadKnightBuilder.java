package com.yvmartor.swingy.models.hero;

import com.yvmartor.swingy.models.artefacts.*;

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
        hero.setXp(0);
    }

    @Override
    public void buildLevel() {
        hero.setLevel(0);
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
                .name("None")
                .points(0)
                .build();
        hero.setWeapon(weapon);
    }

    @Override
    public void buildArmor() {
        Armor armor = new ArmorBuilder()
                .name("None")
                .points(0)
                .build();
        hero.setArmor(armor);
    }

    @Override
    public void buildHelm() {
        Helm helm = new HelmBuilder()
                .name("None")
                .points(0)
                .build();
        hero.setHelm(helm);
    }

    @Override
    public void buildWeaponName() {
        String[] tab = {"Spear Tonbogiri", "Spear Otegine", "Spear Gungnir"};
        hero.setWeaponName(tab);
    }

    @Override
    public void buildArmorName() {
        String[] tab = {"Rusty Armor", "Gold Armor", "Odin's Armor"};
        hero.setArmorName(tab);
    }

    @Override
    public void buildHelmName() {
        String[] tab = {"Rusty Helm", "Gold Helm", "Odin's Helm"};
        hero.setHelmName(tab);
    }

    @Override
    public void buildImage() {
        hero.setImage("/images/chevalier.jpg");
    }

    @Override
    public void buildCoordinates() {
        Coordinates coordinates = new Coordinates(0, 0);
        hero.setCoordinates(coordinates);
    }
}
