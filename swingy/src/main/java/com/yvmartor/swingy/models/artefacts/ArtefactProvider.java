package com.yvmartor.swingy.models.artefacts;

import com.yvmartor.swingy.models.hero.Hero;

import java.util.Random;

public class ArtefactProvider {
    private Hero hero;
    private String vilainsName;
    private String[] heroWeaponName;
    private String[] heroArmorName;
    private String[] heroHelmName;

    public ArtefactProvider(Hero hero, String vilainsName){
        this.hero = hero;
        this.heroWeaponName = hero.getWeaponName();
        this.heroArmorName = hero.getArmorName();
        this.heroHelmName = hero.getHelmName();
        this.vilainsName = vilainsName;
    }

    public Artefact RandomArtefactProvider() {
        Random rand = new Random();
        int chance = rand.nextInt(11);

        if (chance % 2 == 0) {
            int selectArtefact = rand.nextInt(3);

            if (selectArtefact == 0) {
                if (vilainsName.compareTo("Evil Cat") == 0) {
                    Weapon weapon = new WeaponBuilder().name(heroArmorName[0]).points(5).build();
                    return weapon;
                } else if (vilainsName.compareTo("Mickachu") == 0) {
                    Weapon weapon = new WeaponBuilder().name(heroArmorName[1]).points(10).build();
                    return weapon;
                } else {
                    Weapon weapon = new WeaponBuilder().name(heroArmorName[2]).points(15).build();
                    return weapon;
                }
            } else if (selectArtefact == 1) {
                if (vilainsName.compareTo("Evil Cat") == 0) {
                    Armor armor = new ArmorBuilder().name(heroArmorName[0]).points(5).build();
                    return armor;
                } else if (vilainsName.compareTo("Mickachu") == 0) {
                    Armor armor = new ArmorBuilder().name(heroArmorName[1]).points(10).build();
                    return armor;
                } else {
                    Armor armor = new ArmorBuilder().name(heroArmorName[2]).points(15).build();
                    return armor;
                }
            } else if (selectArtefact == 2) {
                if (vilainsName.compareTo("Evil Cat") == 0) {
                    Helm helm = new HelmBuilder().name(heroArmorName[0]).points(5).build();
                    return helm;
                } else if (vilainsName.compareTo("Mickachu") == 0) {
                    Helm helm = new HelmBuilder().name(heroArmorName[1]).points(10).build();
                    return helm;
                } else {
                    Helm helm = new HelmBuilder().name(heroArmorName[2]).points(15).build();
                    return helm;
                }
            }
        }
        return null;
    }
}
