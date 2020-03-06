package com.company;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please input the number of integers you want in the array:");
        int arrayLength = scanner.nextInt();
	int[] intArray = getIntInput(arrayLength);

	intArray = sortIntegers2(intArray);
	printArray(intArray);

    }

    static int[] getIntInput(int arrayLength){
        int[] intArray = new int[arrayLength];
        System.out.println("Please input " + arrayLength + " integers");
        for(int i=0; i<arrayLength; i++){
            intArray[i] = scanner.nextInt();
        }
        return intArray;
    }

    static void printArray(int[] intArray){
        for(int i=0; i<intArray.length; i++){
            System.out.println("Integer No." + i + " is " + intArray[i]);
        }
    }

    static int[] sortIntegers(int[] intArray){
        int[] sortedIntArray = new int[intArray.length];
        int intPosition = 0;
        while (true) {
            for(int i=0; i<intArray.length; i++){
                boolean isSmaller = true;
                for(int j=0; j<intArray.length;j++){
                    if(intArray[i] < intArray[j]){
                        isSmaller = false;
                        break;
                    }
                }
                if(isSmaller) {
                    sortedIntArray[intPosition] = intArray[i];
                    intPosition += 1;
                    if (intPosition == intArray.length) {
                        break;
                    }
                    intArray[i] = Integer.MIN_VALUE;
                }
            }
            if (intPosition == intArray.length) {
                break;
            }
        }
        System.out.println("Integers sorted form max to min");
        return sortedIntArray;
    }

    static int[] sortIntegers2(int[] intArray){
        boolean flag = true;
        int temp;
        while (flag){
            flag = false;
            for(int i=0; i<intArray.length-1; i++){
                if(intArray[i] < intArray[i+1]){
                    temp = intArray[i];
                    intArray[i] = intArray[i+1];
                    intArray[i+1] = temp;
                    flag = true;
                }
            }
        }
        return intArray;
    }


}
