package com.yvmartor.swingy.models.map;
import com.yvmartor.swingy.models.hero.Coordinates;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.villains.Villain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.function.ToDoubleBiFunction;

import static java.lang.Math.round;

public class WorldMap {

    private int dimension;
    private Hero hero;
    private ArrayList<Villain> villainList = new ArrayList<Villain>();
    private ArrayList<int[]> usedCoord = new ArrayList<int[]>();
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

    public void unregisterVilain(Villain villain){
        villainList.remove(villain);
    }

    private void mapDimensionProvider(){
        this.dimension = (this.hero.getLevel() - 1) * 5 + 10 - 1;
    }

    //generate a random int between min and max, usefull to create vilains coordinates
    private int generateRandomInt(int min, int max){
        Random rand = new Random();
        int nb;
        nb = min + rand.nextInt(max-min);
        return nb;
    }

    private int[] generateCoordinates(){
        int x = generateRandomInt(1, dimension - 1);
        int y = generateRandomInt(1, dimension - 1);
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

    public void fight(Villain villain){
        int beginner = generateRandomInt(665, 666);
        //TODO add hp and defense to vilains + simulate the fight with the random begginer.
    }
    
}
