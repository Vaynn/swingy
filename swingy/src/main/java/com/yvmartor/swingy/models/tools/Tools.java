package com.yvmartor.swingy.models.tools;

import java.util.Random;

public class Tools {
    public static final int ERROR = -3;
    public static final int VILLAIN_DEATH = -6;
    public static final int HERO_DEATH = -1;
    public static final int VILLAIN = 666;
    public static final int HERO = 665;
    public static final int SUB = 13;
    public static final int ADD = 14;
    public static final int LUCK = 777;
    public static final int VICTORY = 7777;

    public static final String[] DIRECTIONS_TAB = {
            "Go to the NORTH",
            "Go to the EAST",
            "Go to the SOUTH",
            "Go to the WEST"
    };

    public static final String[] GAME_OVER_TAB = {
            "RETRY",
            "SELECT A NEW HERO",
            "QUIT"
    };

    public static final String[] WINNER_TAB = {
        "CONTINUE TO THE NEXT LEVEL",
        "SELECT A NEW CHARACTER",
        "QUIT"
    };

    public static int generateRandomInt(int min, int max){
        Random rand = new Random();
        int nb;
        nb = min + rand.nextInt(max-min);
        return nb;
    }
}
