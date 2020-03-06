package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static boolean hasSameLastDigit(int a, int b, int c){
        boolean result = false;
        if(isValid(a) && isValid(b) && isValid(c)){
            if ((a % 10 == b % 10) || (a % 10 == c % 10) || (b % 10 == c % 10)) {
                result = true;
            }
        }
        return result;
    }

    public static boolean isValid(int a) {
        if(a >= 10 && a <= 1000){
            return true;
        }
        return false;
    }

    public static boolean isLastDigitEqual(int a, int b){
        if (a % 10 == b % 10) {
            return true;
        }
        return false;
    }
}
