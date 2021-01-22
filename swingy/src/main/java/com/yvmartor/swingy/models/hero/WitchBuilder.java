package com.yvmartor.swingy.models.hero;

import com.yvmartor.swingy.models.artefacts.*;

public class WitchBuilder extends HeroBuilder{
    @Override
    public void buildHeroClass() {
        hero.setHeroClass("Witch");
    }

    @Override
    public void buildName() {
        hero.setName("Mafalda");
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
        hero.setAttak(25);
    }

    @Override
    public void buildDefense() {
        hero.setDefense(40);
    }

    @Override
    public void buildHitPoints() {
        hero.setHitPoints(100);
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
        String[] tab = {"Deadwood Wand", "Saroumane's Grimoire", "Lightsaber"};
        hero.setWeaponName(tab);
    }

    @Override
    public void buildArmorName() {
        String[] tab = {"Worn Gown", "Steel Gown", "Mithril Gown"};
        hero.setArmorName(tab);
    }

    @Override
    public void buildHelmName() {
        String[] tab = {"Rusty Helm", "Gold Helm", "Mithril Helm"};
        hero.setHelmName(tab);
    }

    @Override
    public void buildImage() {
        hero.setImage("/images/sorciere.jpg");
    }

    @Override
    public void buildGif() {
        hero.setGif("/images/witch.gif");
    }

    @Override
    public void buildCoordinates() {
        Coordinates coordinates = new Coordinates(0, 0);
        hero.setCoordinates(coordinates);
    }
}
