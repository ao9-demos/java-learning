package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(isCatPlaying(true, 1));
        System.out.println(isCatPlaying(true,40));
        System.out.println(isCatPlaying(false,40));
        System.out.println(isCatPlaying(false,25));
    }

    public static boolean isCatPlaying(boolean summer,int temperature) {
        boolean result = false;
        if (temperature >= 25 && temperature <= 45) {
            if (summer) {
                result = true;
            } else if (temperature <= 35) {
                result = true;
            }
        }
        return result;
    }
}
