package com.yvmartor.swingy.models.map;

import com.yvmartor.swingy.models.artefacts.Artefact;
import com.yvmartor.swingy.models.hero.Coordinates;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.tools.Tools;
import com.yvmartor.swingy.models.villains.Villain;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static com.yvmartor.swingy.models.tools.Tools.*;
import static java.lang.Math.round;

public class WorldMap {

    private int dimension;
    private Hero hero;
    private Hero retryHero = new Hero();
    private ArrayList<Villain> villainList = new ArrayList<Villain>();
    private ArrayList<int[]> usedCoord = new ArrayList<int[]>();
    private JFrame mapFrame = null;
    private String fightTelling = "";


    //register hero on the center of the map
    public void registerHero(Hero hero){
        this.hero = hero;
        this.retryHero.copy(hero);
        mapDimensionProvider();
        this.hero.getCoordinates().setX((int)round((double)dimension/2));
        this.hero.getCoordinates().setY((int)round((double)dimension/2));
        int[] tab = {(int)round((double)dimension/2), (int)round((double)dimension/2)};
        usedCoord.add(tab);
    }

    //register vilains on the map, checking if there is already someone on the current coordinates
    public void registerVilain(Villain villain){
        int[] tab = generateCoordinates();
        while (isCoordAlreadyUsed(tab) != false){
            tab = generateCoordinates();
        }
        Coordinates coor = new Coordinates(tab[0], tab[1]);
        villain.setCoordinates(coor);
        usedCoord.add(tab);
        villainList.add(villain);
    }

    public Hero getHero() {
        return hero;
    }

    public int getDimension() {
        return dimension;
    }

    public void setFightTelling(String fightTelling) {
        this.fightTelling = fightTelling;
    }

    public void unregisterVilain(Villain villain){
        villainList.remove(villain);
    }

    private void mapDimensionProvider(){
        this.dimension = (this.hero.getLevel() - 1) * 5 + 10 - 1;
    }

    //generate a random int between min and max, usefull to create vilains coordinates
    private int[] generateCoordinates(){
        int x = Tools.generateRandomInt(1, dimension - 1);
        int y = Tools.generateRandomInt(1, dimension - 1);
        int[] tab = {x, y};
        return tab;
    }

    //check if there is not a vilains in this case yet
    private boolean isCoordAlreadyUsed(int[] tab){
        for (int i =0; i < usedCoord.size(); i++) {
            int[] tmp = usedCoord.get(i);
            if (tmp[0] == tab[0] && tmp[1] == tab[1]) {
                return true;
            }
        }
        return false;
    }

    //calculate the number of vilains to register on the map (40%)
    public int vilainProportionCalculator(){
        int totalCase = dimension * dimension - ((dimension * 2) - 1);
        return (totalCase * 40) / 100;
    }

    //update hero coordinates after a move
    public void updateHeroCoordinates(int userChoice){
        this.hero.updateCoordinates(userChoice);
    }

    //update hero Artefact when he won it.
    public void updateArtefact(Artefact artefact) {this.hero.updateArtefact(artefact);}

    //update hero XP return true if level up
    public boolean updateXP(int xp){
        boolean levelUp;
        levelUp = this.hero.updateXP(xp);
        return levelUp;
    }

    //After hero move, check if there is a villain on the current coordinates, if true return vilain Object
    public Villain isHeroMeetVilain(){
        int[] coor = hero.getCoordinates().getCoordinates();

        for (int i = 0; i < villainList.size(); i++){
            int[] vilCoor = villainList.get(i).getCoordinates().getCoordinates();
            if (Arrays.equals(coor, vilCoor)){
                return villainList.get(i);
            }
        }
        return null;
    }

    public boolean isHeroReachTheEdge(int mode){
        int[] coor = hero.getCoordinates().getCoordinates();
        if (mode == CONSOLE_MODE && (coor[0] == 0 || coor[1] == 0 || coor[0] == dimension - 1 || coor[1] == dimension - 1))
            return true;
        else if (mode == GUI_MODE && (coor[0] == 1 || coor[1] == 1 || coor[0] == dimension || coor[1] == dimension))
            return true;
        return false;
    }

    public int fightHeroTurn(Villain villain, int villainHP){
        int villain_dodge = Tools.generateRandomInt(770, 780); //Randomly select if the villain dodge the attack (1/10)
        if (villain_dodge != LUCK){
            int tempHP = villain.underAttack(villainHP);
            if (tempHP == VILLAIN_DEATH || tempHP == HERO_DEATH)
                return tempHP;
            fightTelling += "\tYou attack the " + villain.getName() + ".  He has " + tempHP + " HP left.\n";
            int doubleShot = Tools.generateRandomInt(770, 780); //Randomly select if the hero attack a second time. (1/10)
            if (doubleShot == LUCK){
                fightTelling += "\tYou are on fire, you launch a second attack.\n";
                tempHP = villain.underAttack(tempHP);
                if (tempHP == VILLAIN_DEATH || tempHP == HERO_DEATH)
                    return tempHP;
                fightTelling += "\tYou attack the " + villain.getName() + ".  He has " + tempHP + " HP left.\n";
            }
            return tempHP;
        } else {
            fightTelling += "\tCrap! You're attack was too slow, the ennemy dodged.\n";
        }
        return villainHP;
    }

    public int fightVillainTurn(Villain villain, int myHP){
        int fatal_attak = Tools.generateRandomInt(770, 1070);//Randomly select if the villain make a fatal attack(1/300)
        if (fatal_attak == LUCK){
            fightTelling += "\tThe " + villain.getName() + " multiply his strength. He turns you into powder.\n";
            return HERO_DEATH;
        }
        int hero_dodge = Tools.generateRandomInt(770, 780); //Randomly select if the hero dodge the attack (1/10)
        if (hero_dodge != LUCK){
            int tempHP = hero.underAttack(villain, myHP);
            if (tempHP == VILLAIN_DEATH || tempHP == HERO_DEATH)
                return tempHP;
            fightTelling += "\tThe " + villain.getName() + " attack you.  You have  " + tempHP + " HP left.\n";
            return tempHP;
        }
        else {
            fightTelling += "\tThanks to your agility, you dodged the attack. You receive no damage for this turn \n";
        }
        return myHP;
    }

    public Object[] fight(Villain villain){
        int beginner = Tools.generateRandomInt(HERO, VILLAIN); //Randomly select who begin to attack (50% of chance)
        int villainHP = villain.getHp();
        int heroHP = hero.getHitPoints();
        int tmpHP;
        fightTelling = "\tLet's the fight begin !\n";
        if (beginner == HERO){
            fightTelling += "\tYou attack first\n";
            while (villainHP > VILLAIN_DEATH || heroHP > HERO_DEATH) {
                tmpHP = fightHeroTurn(villain, villainHP);
                if (tmpHP != HERO_DEATH && tmpHP != VILLAIN_DEATH)
                    villainHP = tmpHP;
                else
                    return new Object[]{fightTelling, tmpHP};
                tmpHP = fightVillainTurn(villain, heroHP);
                if (tmpHP != HERO_DEATH && tmpHP != VILLAIN_DEATH)
                    heroHP = tmpHP;
                else
                    return new Object[]{fightTelling, tmpHP};
            }

        }
        else if (beginner == VILLAIN){
            fightTelling += "\tThe enemy attack first";
            while (villainHP > VILLAIN_DEATH || heroHP > HERO_DEATH) {
                tmpHP = fightVillainTurn(villain, heroHP);
                if (tmpHP != HERO_DEATH && tmpHP != VILLAIN_DEATH)
                    heroHP = tmpHP;
                else
                    return new Object[]{fightTelling, tmpHP};
                tmpHP = fightHeroTurn(villain, villainHP);
                if (tmpHP != HERO_DEATH && tmpHP != VILLAIN_DEATH)
                    villainHP = tmpHP;
                else
                    return new Object[]{fightTelling, tmpHP};
            }
        }

        return null;
    }

    public Artefact getHeroArtefact(Artefact villainArtefact, Hero hero){

        Artefact heroArtefact = null;
        heroArtefact = villainArtefact.getIncreasedStat().compareTo("defense") == 0
                ? heroArtefact = hero.getArmor()
                : villainArtefact.getIncreasedStat().compareTo("attack") == 0
                ? heroArtefact = hero.getWeapon()
                : villainArtefact.getIncreasedStat().compareTo("hit points") == 0
                ? heroArtefact = hero.getHelm()
                : heroArtefact;
        return heroArtefact;
    }

    public String getFightTelling() {
        return fightTelling;
    }

    public JFrame getMapFrame() {
        return mapFrame;
    }

    public void setMapFrame(JFrame mapFrame) {
        this.mapFrame = mapFrame;
    }

    public Hero getRetryHero() {
        return retryHero;
    }

    public void setRetryHero(Hero retryHero) {
        this.retryHero = retryHero;
    }
}
