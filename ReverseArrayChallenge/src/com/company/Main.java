package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("How many integers do you need?");
        int count = scanner.nextInt();
        int[] intArray = readIntegers(count);
        System.out.println("intArray.toString() = " + Arrays.toString(intArray));
        reverse(intArray);

        System.out.println("intArray = " + Arrays.toString(intArray));
        int[] clonedArray = intArray.clone();
        System.out.println("clonedArray = " + Arrays.toString(clonedArray));

    }


    static int[] readIntegers(int count){
        int[] intArray = new int[count];
        System.out.println("Please input " + count + " integers");
        for(int i=0; i<count; i++){
            intArray[i] = scanner.nextInt();
        }
        return intArray;
    }

    static void reverse(int[] intArray){
        int count = intArray.length;
        int temp = 0;
        for(int i=0; i<(count / 2); i++){
            temp = intArray[i];
            intArray[i] = intArray[count -1 - i];
            intArray[count -1 - i] = temp;
        }
    }
}
