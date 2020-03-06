package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] intArray = getIntInput(5);

        for(int i=0; i<intArray.length; i++){
            System.out.println("The int No." + (i+1) + " is " + intArray[i]);
        }

        System.out.println("Average of the int array is " + getAverage(intArray));

    }

    static int[] getIntInput(int arrayLength){
        int[] intArray = new int[arrayLength];
        for(int i=0; i<arrayLength; i++){
            System.out.println("Please input int No." + (i+1));
            intArray[i] = scanner.nextInt();
        }
        return intArray;
    }

    static double getAverage(int[] intArray){
        int sum = 0;
        for(int i=0; i<intArray.length; i++){
            sum += intArray[i];
        }
        double average = (double) sum / (double) intArray.length;
        return average;
    }
}
