package com.yvmartor.swingy.models.hero;

import com.yvmartor.swingy.artefacts.*;

public class ChickenHeroBuilder extends HeroBuilder {
    @Override
    public void buildHeroClass() {
        hero.setHeroClass("Chicken");
    }

    @Override
    public void buildName() {
        hero.setName("Augustine");
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
        hero.setAttak(16);
    }

    @Override
    public void buildDefense() {
        hero.setDefense(30);
    }

    @Override
    public void buildHitPoints() {
        hero.setHitPoints(100);
    }

    @Override
    public void buildWeapon() {
        Weapon weapon = new WeaponBuilder()
                            .name("Rusty Beak")
                            .material("rusty")
                            .attak(1)
                            .build();
        hero.setWeapon(weapon);
    }

    @Override
    public void buildArmor() {
        Armor armor = new ArmorBuilder()
                            .name("Rusty Feathers")
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
        hero.setImage("/images/chicken.jpg");
    }
}
