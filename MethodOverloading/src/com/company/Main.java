package com.company;

public class Main {

    public static void main(String[] args) {
	double cm = cacFeetAndInchesToCm(11,5);
        System.out.println("cm = " + cm);
        cm = cacFeetAndInchesToCm(56);
        System.out.println("cm = " + cm);
        cm = cacFeetAndInchesToCm(11,13);
        System.out.println("cm = " + cm);
        cm = cacFeetAndInchesToCm(-1,12);
        System.out.println("cm = " + cm);
        cm = cacFeetAndInchesToCm(-9);
        System.out.println("cm = " + cm);
    }

    public static double cacFeetAndInchesToCm(int feet, int inches){
        double cm = -1;
        if(feet >= 0 && inches >=0 && inches <=12) {
            cm = (feet * 12 + inches) * 2.54;
        }
        return cm;
    }

    public static double cacFeetAndInchesToCm(int inches){
        double cm = -1;
        if(inches >=0) {
            cm = inches * 2.54;
        }
        return cm;
    }
}
