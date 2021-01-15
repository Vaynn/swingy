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
                    return new WeaponBuilder().name(heroWeaponName[0]).points(5).build();
                } else if (vilainsName.compareTo("Mickachu") == 0) {
                    return new WeaponBuilder().name(heroWeaponName[1]).points(10).build();
                } else if (vilainsName.compareTo("Badass Mickey") == 0) {
                    return new WeaponBuilder().name(heroWeaponName[2]).points(15).build();
                }
            }
            else if (selectArtefact == 1) {
                if (vilainsName.compareTo("Evil Cat") == 0)
                    return new ArmorBuilder().name(heroArmorName[0]).points(5).build();
                else if (vilainsName.compareTo("Mickachu") == 0)
                    return new ArmorBuilder().name(heroArmorName[1]).points(10).build();
                else if (vilainsName.compareTo("Badass Mickey") == 0)
                    return new ArmorBuilder().name(heroArmorName[2]).points(15).build();
                }
            else if (selectArtefact == 2){
                if (vilainsName.compareTo("Evil Cat") == 0)
                    return new HelmBuilder().name(heroHelmName[0]).points(5).build();
                else if (vilainsName.compareTo("Mickachu") == 0)
                    return new HelmBuilder().name(heroHelmName[1]).points(10).build();
                else
                    return new HelmBuilder().name(heroHelmName[2]).points(15).build();
                }
            }
        return new HelmBuilder().name("None").points(0).build();
    }
}
