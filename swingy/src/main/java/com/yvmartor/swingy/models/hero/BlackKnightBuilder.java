package com.yvmartor.swingy.models.hero;

import com.yvmartor.swingy.models.artefacts.*;

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
    public void buildImage() {
        hero.setImage("/images/black_knight.jpg");
    }

    @Override
    public void buildCoordinates() {
        Coordinates coordinates = new Coordinates(0, 0);
        hero.setCoordinates(coordinates);
    }

    @Override
    public void buildWeaponName() {
        String[] tab = {"Sword Balisarde", "Sword Graban", "Sword Durendal"};
        hero.setWeaponName(tab);
    }

    @Override
    public void buildArmorName() {
        String[] tab = {"Rusty Armor", "Gold Armor", "Adamanthe Armor"};
        hero.setWeaponName(tab);
    }

    @Override
    public void buildHelmName() {
        String[] tab = {"Rusty Helm", "Gold Helm", "Adamanthe Helm"};
        hero.setHelmName(tab);
    }
}
