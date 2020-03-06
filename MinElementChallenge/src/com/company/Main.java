package com.company;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("How many integers do you want?");
        int count = scanner.nextInt();
        int[] intArray = readIntegers(count);
        int min = findMin(intArray);
        System.out.println("min = " + min);
    }

    static int[] readIntegers(int count){
        int[] intArray = new int[count];
        System.out.println("Please input " + count + " integers");
        for(int i=0; i<count; i++){
            intArray[i] = scanner.nextInt();
        }
        return intArray;
    }

    static int findMin(int[] intArray){
        int min = intArray[0];
        for(int i=1; i<intArray.length; i++){
            if (intArray[i] < min) {
                min = intArray[i];
            }
        }
        return min;
    }
}
