package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(sumFirstAndLastDigit(123));
    }

    public static int sumFirstAndLastDigit(int number){
        if (number < 0) {
            return -1;
        }
        int firstDigit = number % 10;
        int lastDigit = 0;
        while (number >= 10) {
            number = number / 10;
        }
        lastDigit = number;
        return (firstDigit + lastDigit);
    }
}
