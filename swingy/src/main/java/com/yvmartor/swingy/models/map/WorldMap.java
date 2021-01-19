package com.yvmartor.swingy.models.map;
import com.yvmartor.swingy.models.hero.Coordinates;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.scenario.ConsoleStringColor;
import com.yvmartor.swingy.models.tools.Tools;
import com.yvmartor.swingy.models.villains.Villain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.ToDoubleBiFunction;

import static com.yvmartor.swingy.models.tools.Tools.*;
import static java.lang.Math.round;

public class WorldMap {

    private int dimension;
    private Hero hero;
    private ArrayList<Villain> villainList = new ArrayList<Villain>();
    private ArrayList<int[]> usedCoord = new ArrayList<int[]>();
    private String fightTelling = "";
    private static final int VILLAIN = 666;
    private static final int HERO = 665;

    //register hero on the center of the map
    public void registerHero(Hero hero){
        this.hero = hero;
        mapDimensionProvider();
        this.hero.getCoordinates().setX((int)round((double)dimension/2));
        this.hero.getCoordinates().setY((int)round((double)dimension/2));
        int[] tab = {(int)round((double)dimension/2), (int)round((double)dimension/2)};
        usedCoord.add(tab);
    }

    //register vilains on the map, checking if there is already someone on the current coordinates
    public void registerVilain(Villain villain){
        int[] tab = generateCoordinates();
        while (isCoordAlreadyUsed(tab)){
            tab = generateCoordinates();
        }
        Coordinates coor = new Coordinates(tab[0], tab[1]);
        villain.setCoordinates(coor);
        usedCoord.add(tab);
        villainList.add(villain);
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
        if (this.usedCoord.contains(tab))
                return true;
        return false;
    }

    //calculate the number of vilains to register on the map (40%)
    public int vilainProportionCalculator(){
        int totalCase = dimension * dimension;
        return (totalCase * 40) / 100;
    }

    public void updateHeroCoordinates(int userChoice){
        this.hero.updateCoordinates(userChoice);
    }

    //After hero move, check if there is a vilain on the current coordinates, if true return vilain Object
    public Villain isHeroMeetVilain(){
        int[] coor = hero.getCoordinates().getCoordonates();

        for (int i = 0; i < villainList.size(); i++){
            int[] vilCoor = villainList.get(i).getCoordinates().getCoordonates();
            if (Arrays.equals(coor, vilCoor)){
                return villainList.get(i);
            }
        }
        return null;
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
    
}
