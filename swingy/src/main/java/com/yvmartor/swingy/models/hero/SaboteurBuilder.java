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
        hero.setXp(0);
    }

    @Override
    public void buildLevel() {
        hero.setLevel(0);
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
        String[] tab = {"Firecrackers", "Plasttic Explosive ", "TNT"};
        hero.setWeaponName(tab);
    }

    @Override
    public void buildArmorName() {
        String[] tab = {"Rusty Chestplate", "Steel Chestplate", "BlackBeard ChestPlate"};
        hero.setArmorName(tab);
    }

    @Override
    public void buildHelmName() {
        String[] tab = {"Rusty Helm", "Gold Helm", "BlackBeard Helm"};
        hero.setHelmName(tab);
    }

    @Override
    public void buildImage() {
        hero.setImage("/images/saboteur.jpg");
    }

    @Override
    public void buildCoordinates() {
        Coordinates coordinates = new Coordinates(0, 0);
        hero.setCoordinates(coordinates);
    }
}
