package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static void printNumberInWord(int number){
        String result;
        if(number == 0){
            result = "ZERO";
        } else if (number == 1) {
            result = "ONE";
        } else if (number == 2) {
            result = "TWO";
        } else if (number == 3) {
            result = "THREE";
        } else if (number == 4) {
            result = "FOUR";
        } else if (number == 5) {
            result = "FIVE";
        } else if (number == 6) {
            result = "SIX";
        } else if (number == 7) {
            result = "SEVEN";
        } else if (number == 8) {
            result = "EIGHT";
        } else if (number == 9) {
            result = "NINE";
        } else {
            result = "OTHER";
        }
        System.out.println(result);
    }
}
