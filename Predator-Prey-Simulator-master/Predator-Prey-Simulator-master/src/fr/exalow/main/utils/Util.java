package fr.exalow.main.utils;

public class Util {

    public static int randInt(int max, int min) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }

}
