package fr.uracraft.uramod.utils;

public class Random {

    public Random(){
    }

    public static int roll(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}