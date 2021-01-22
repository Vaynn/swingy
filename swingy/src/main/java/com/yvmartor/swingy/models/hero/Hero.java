package com.yvmartor.swingy.models.hero;

import com.yvmartor.swingy.models.artefacts.*;
import com.yvmartor.swingy.models.map.WorldMap;
import com.yvmartor.swingy.models.villains.Villain;

import static com.yvmartor.swingy.models.tools.Tools.HERO_DEATH;
import static com.yvmartor.swingy.models.tools.Tools.VILLAIN_DEATH;

public class Hero {
    private String heroClass = "";
    private String name = "";
    private double xp = 0;
    private int level = 0;
    private int attak = 0;
    private int defense = 0;
    private int hitPoints = 0;
    private Weapon weapon = new WeaponBuilder()
                                .name("")
                                .points(0)
                                .build();

    private Armor armor = new ArmorBuilder()
                                .name("")
                                .points(0)
                                .build();

    private Helm helm = new HelmBuilder()
                                .name("")
                                .points(0)
                                .build();

    private String[] weaponName;
    private String[] armorName;
    private String[] helmName;

    private String image = "";

    private String gif = "";

    private Coordinates coordinates = new Coordinates(0, 0);

    private WorldMap worldMap;

    public String getHeroClass() {
        return heroClass;
    }

    public String getName() {
        return name;
    }

    public double getXp() {
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

    public String getGif() {
        return gif;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String[] getWeaponName() {
        return weaponName;
    }

    public String[] getArmorName() {
        return armorName;
    }

    public String[] getHelmName() {
        return helmName;
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setXp(double xp) {
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
        this.attak -= this.weapon.getPoints();
        this.weapon = weapon;
        this.attak += weapon.getPoints();
    }

    public void setArmor(Armor armor) {
        this.defense -= this.armor.getPoints();
        this.armor = armor;
        this.defense += armor.getPoints();
    }

    public void setHelm(Helm helm) {
        this.hitPoints -= this.helm.getPoints();
        this.helm = helm;
        this.hitPoints += helm.getPoints();
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setWeaponName(String[] weaponName) {
        this.weaponName = weaponName;
    }

    public void setArmorName(String[] armorName) {
        this.armorName = armorName;
    }

    public void setHelmName(String[] helmName) {
        this.helmName = helmName;
    }

    public void updateCoordinates(int userChoice) {
        if (userChoice == 1)
            this.coordinates.setY(this.coordinates.getY() - 1);
        if (userChoice == 2)
            this.coordinates.setX(this.coordinates.getX() + 1);
        if (userChoice == 3)
            this.coordinates.setY(this.coordinates.getY() + 1);
        if (userChoice == 4)
            this.coordinates.setX(this.coordinates.getX() - 1);
    }

    public void registerWorldMap(WorldMap worldMap){
        worldMap.registerHero(this);
        this.worldMap = worldMap;
    }

    public void updateArtefact(Artefact artefact){
        if (artefact instanceof Armor)
            setArmor((Armor)artefact);
        else if (artefact instanceof Helm)
            setHelm((Helm)artefact);
        else if (artefact instanceof Weapon)
            setWeapon((Weapon)artefact);
    }

    public int underAttack(Villain villain, int myHP){
        int villainAttack = villain.getAttak();
        int myDefense = getDefense();
        if (myDefense >= villainAttack)
            myHP -= 1;
        else{
            myHP -= villainAttack - myDefense;
        }
        if (myHP <= 0)
            myHP = HERO_DEATH;
        return myHP;

    }

    public boolean updateXP(int xp) {
        double nextLevel = getLevel() + 1;
        double nextXP = nextLevel * 1000 + Math.pow(nextLevel - 1, 2) * 450;
        double newXP = getXp() + xp;
        setXp(newXP);
        if (newXP >= nextXP) {
            setLevel(getLevel() + 1);
            return true;
        }
        return false;
    }
}
