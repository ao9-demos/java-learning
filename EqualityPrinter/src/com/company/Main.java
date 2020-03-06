package com.company;

public class Main {

    public static void main(String[] args) {
	printEqual(1,2,2);
	printEqual(1,1,1);
	printEqual(1,2,3);
	printEqual(1,1,-1);
    }

    public static void printEqual(int a, int b, int c) {
        String result = "Invalid Value";
        if (a >= 0 && b >= 0 && c >= 0) {
            if(a == b && a == c){
                result = "All numbers are equal";
            } else if (a != b && a != c && b != c) {
                result = "All numbers are different";
            } else {
                result = "Neither all are equal or different";
            }
        }
        System.out.println(result);
    }
}
