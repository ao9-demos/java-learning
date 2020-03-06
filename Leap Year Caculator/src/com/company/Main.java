package com.company;

public class Main {

    public static void main(String[] args) {
        boolean isLeapYear = false;
        isLeapYear = isLeapYear(1700);
        System.out.println("isLeapYear = " + isLeapYear);
        isLeapYear = isLeapYear(96);
        System.out.println("isLeapYear = " + isLeapYear);
        isLeapYear = isLeapYear(1600);
        System.out.println("isLeapYear = " + isLeapYear);
    }

    public static boolean isLeapYear(int year) {
        boolean isLeapYear = false;
        if (year >= 1 && year <= 9999) {
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        isLeapYear = true;
                    }
                } else {
                    isLeapYear = true;
                }
            }
        }
        return isLeapYear;
    }
}
