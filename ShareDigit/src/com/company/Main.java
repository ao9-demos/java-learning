package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12,23));
        System.out.println(hasSharedDigit(31,23));
        System.out.println(hasSharedDigit(-12,23));
        System.out.println(hasSharedDigit(2,23));
        System.out.println(hasSharedDigit(12,223));
        System.out.println(hasSharedDigit(12,33));
    }

    public static boolean hasSharedDigit(int a, int b){
        boolean result = false;
        if (a >= 10 && a <= 99 && b >= 10 && b <= 99) {
            int a1 = a % 10;
            int a2 = a / 10;
            int b1 = b % 10;
            int b2 = b / 10;
            if (a1 == b1 || a1 == b2 || a2 == b1 || a2 == b2) {
                result = true;
            }
        }
        return result;
    }
}
