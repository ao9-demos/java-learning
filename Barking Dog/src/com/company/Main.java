package com.company;

public class Main {

    public static void main(String[] args) {
	boolean shouldWakeUp = shouldWakeUp(false,0);
        System.out.println("shouldWakeUp = " + shouldWakeUp);
	shouldWakeUp = shouldWakeUp(true,2);
        System.out.println("shouldWakeUp = " + shouldWakeUp);
	shouldWakeUp = shouldWakeUp(true,89);
        System.out.println("shouldWakeUp = " + shouldWakeUp);

    }

    public static boolean shouldWakeUp(boolean barking,int hourOfDay) {
        boolean shouldWakeup = false;
        if(barking && ((hourOfDay >= 0 && hourOfDay < 8) || (hourOfDay == 23))) {
            shouldWakeup = true;
        }
        return shouldWakeup;
    }
}
