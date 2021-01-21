package com.yvmartor.swingy.models.tools;

import java.util.Random;

public class Tools {
    public static final int ERROR = -3;
    public static final int VILLAIN_DEATH = -6;
    public static final int HERO_DEATH = -1;
    public static final int SUB = 13;
    public static final int ADD = 14;
    public static final int LUCK = 777;
    public static final int VICTORY = 7777;

    public static int generateRandomInt(int min, int max){
        Random rand = new Random();
        int nb;
        nb = min + rand.nextInt(max-min);
        return nb;
    }
}
