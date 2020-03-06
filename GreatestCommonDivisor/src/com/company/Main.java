package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(12, 1728));
    }

    public static int getGreatestCommonDivisor(int a, int b){
        int commonDivisor = -1;
        if (a >= 10 && b >= 10) {
            for(int i=1;(i <= a && i <= b); i++) {
                if (a % i == 0 & b % i == 0) {
                    commonDivisor = i;
                }
            }
        }
        return commonDivisor;
    }
}
