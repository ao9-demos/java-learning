package com.company;

public class Main {

    public static void main(String[] args) {
	printSquareStar(4);
    }

    public static void  printSquareStar(int number){
        if(number < 5){
            System.out.println("Invalid Value");
        } else {
            for (int rowNumber = 1; rowNumber <= number; rowNumber++) {
                for (int columnNumber = 1; columnNumber <= number; columnNumber++) {
                    if ((rowNumber == 1) || (rowNumber == number) || (columnNumber == 1) || (columnNumber == number)) {
                        System.out.print("*");
                    } else if (rowNumber == columnNumber || rowNumber + columnNumber == number + 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                    if (columnNumber == number) {
                        System.out.println();
                    }
                }
            }
        }
    }
}
