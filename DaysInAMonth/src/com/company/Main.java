package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(isLeapYear(100));
        System.out.println(isLeapYear(1600));
    }

    public static boolean isLeapYear(int year){
        boolean result = false;
        if(year >= 1 && year <= 9999){
            if(year % 4 == 0){
                if(year % 100 != 0) {
                    result = true;
                } else if (year % 400 == 0){
                    result = true;
                }
            }
        }
        return result;
    }

    public static int getDaysInMonth(int month, int year){
        int result = -1;
        if(month >= 1 && month <= 12 && year >=1 && year <= 9999) {
            if (month != 2) {
                switch (month){
                    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                        result = 31;
                        break;
                    case 4: case 6: case 9: case 11:
                        result = 30;
                        break;
                }
            } else if(isLeapYear(year)){
                result =29;
            } else {
                result = 28;
            }
        }
        return result;
    }
}
