package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static boolean hasTeen (int a, int b, int c) {
        boolean hasTeen = false;
        if (a >= 13 & a <= 19) {
            hasTeen = true;
        } else if (b >= 13 & b <= 19) {
            hasTeen = true;
        } else if (c >= 13 & c <= 19) {
            hasTeen = true;
        }
        return hasTeen;
    }

    public static boolean isTeen(int a) {
        boolean isTeen = false;
        if (a >= 13 & a <= 19) {
            isTeen = true;
        }
        return isTeen;
    }
}
