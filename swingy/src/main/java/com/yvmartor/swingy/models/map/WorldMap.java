package com.yvmartor.swingy.models.map;
import com.yvmartor.swingy.models.hero.Coordinates;
import com.yvmartor.swingy.models.hero.Hero;
import com.yvmartor.swingy.models.vilains.Vilain;
import com.yvmartor.swingy.models.map.WorldMap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.round;

public class WorldMap {

    private int dimension;
    private Hero hero;
    private ArrayList<Vilain> vilainList = new ArrayList<Vilain>();
    private ArrayList<int[]> usedCoord = new ArrayList<int[]>();

    public void registerHero(Hero hero){
        this.hero = hero;
        mapDimensionProvider();
        this.hero.getCoordinates().setX((int)round((double)dimension/2));
        this.hero.getCoordinates().setY((int)round((double)dimension/2));
        int[] tab = {(int)round((double)dimension/2), (int)round((double)dimension/2)};
        usedCoord.add(tab);
    }

    public void registerVilain(Vilain vilain){
        int[] tab = generateCoordinates();
        while (isCoordAlreadyUsed(tab)){
            tab = generateCoordinates();
        }
        Coordinates coor = new Coordinates(tab[0], tab[1]);
        vilain.setCoordinates(coor);
        usedCoord.add(tab);
        vilainList.add(vilain);
    }

    public void unregisterVilain(Vilain vilain){
        vilainList.remove(vilain);
    }

    private void mapDimensionProvider(){
        this.dimension = (this.hero.getLevel() - 1) * 5 + 10 - 1;
    }

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

    public Vilain isHeroMeetVilain(){
        int[] coor = hero.getCoordinates().getCoordonates();

        for (int i = 0; i < vilainList.size(); i++){
            int[] vilCoor = vilainList.get(i).getCoordinates().getCoordonates();
            if (Arrays.equals(coor, vilCoor)){
                return vilainList.get(i);
            }
        }
        return null;
    }
}
