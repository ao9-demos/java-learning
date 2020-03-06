package com.company;

public class Main {

    public static void main(String[] args) {
        boolean areEqual = areEqualByThreeDecimalPlaces(3.1234, 3.1239);
        System.out.println("areEqual = " + areEqual);
        areEqual = areEqualByThreeDecimalPlaces2(3.1756, 3.175);
        System.out.println("areEqual = " + areEqual);

    }

    public static boolean areEqualByThreeDecimalPlaces(double d1, double d2) {
        boolean areEqual = false;
        int x = (int) (d1 * 1000);
        d1 = (double) x / 1000;
        int y = (int) (d2 * 1000);
        d2 = (double) y / 1000;

        if (d1 == d2) {
            areEqual = true;
        }
        return areEqual;
    }

    public static boolean areEqualByThreeDecimalPlaces2(double d1, double d2) {

        int x = (int) d1;
        System.out.println("x = " + x);

        int y = (int) d2;
        System.out.println("y = " + y);

        if (x == y) {

            int a = (int) ((d1 % x) * 1000);
            System.out.println("a = " + a);
            System.out.println(d1 % x);
            System.out.println((d1 % x) * 1000);
            System.out.println((int) ((d1 % x) * 1000));

            int b = (int) ((d2 % y) * 1000);
            System.out.println("b = " + b);
            System.out.println(d2 % x);
            System.out.println((d2 % x) * 1000);
            System.out.println((int) ((d2 % x) * 1000));


            if (a == b) {

                return true;

            }

        }

        return false;

    }
}
