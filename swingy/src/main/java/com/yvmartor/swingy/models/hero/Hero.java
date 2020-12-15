package com.yvmartor.swingy.models.hero;

import com.yvmartor.swingy.artefacts.*;

public class Hero {
    private String heroClass = "";
    private String name = "";
    private long xp = 0;
    private int level = 0;
    private int attak = 0;
    private int defense = 0;
    private int hitPoints = 0;
    private Weapon weapon = new WeaponBuilder()
                                .name("")
                                .material("")
                                .attak(0)
                                .build();

    private Armor armor = new ArmorBuilder()
                                .name("")
                                .material("")
                                .defense(0)
                                .build();

    private Helm helm = new HelmBuilder()
                                .name("")
                                .material("")
                                .hitPoints(0)
                                .build();

    private String image = "";

    public String getHeroClass() {
        return heroClass;
    }

    public String getName() {
        return name;
    }

    public long getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public int getAttak() {
        return attak;
    }

    public int getDefense() {
        return defense;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public Helm getHelm() {
        return helm;
    }

    public String getImage() {
        return image;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setXp(long xp) {
        this.xp = xp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAttak(int attak) {
        this.attak = attak;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setWeapon(Weapon weapon) {
        this.attak -= this.weapon.getAttak();
        this.weapon = weapon;
        this.attak += weapon.getAttak();
    }

    public void setArmor(Armor armor) {
        this.defense -= this.armor.getDefense();
        this.armor = armor;
        this.defense += armor.getDefense();
    }

    public void setHelm(Helm helm) {
        this.hitPoints -= this.helm.getHitPoints();
        this.helm = helm;
        this.hitPoints += helm.getHitPoints();
    }

    public void setImage(String image) {
        this.image = image;
    }
}
