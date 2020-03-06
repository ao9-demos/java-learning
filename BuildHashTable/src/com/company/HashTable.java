package com.company;

import java.util.Arrays;

public class HashTable {
    String[] storeArray;
    int size;

    public HashTable(int size) {
        this.size = size;
        storeArray = new String[size];
        Arrays.fill(storeArray, "-1");
    }

    public void add1(String[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            String key = inputArray[i];
            int value = Integer.parseInt(key);
            storeArray[value] = key;
        }
    }

    public void add2(String[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            String key = inputArray[i];
            int value = Integer.parseInt(key) % size;
            while (value < size - 1 && storeArray[value] != "-1") {
                System.out.println("Collision at value " + value + ", move to next");
                value++;
            }
            if (value < size - 1) {
                storeArray[value] = key;
            } else {
                System.out.println("No place to store " + key);
            }
        }
    }

    public int get2(String key) {
        int value = Integer.parseInt(key) % size;
        while (value < size && storeArray[value] != key) {
            value++;
        }
        if (value < size) {
            return value;
        } else {
            return -1;
        }
    }

    public void print() {
        int rowNum = (int) Math.ceil((double) size / (double) 10);
        for (int j = 0; j < rowNum; j++) {
            for (int i = 0; (i + j * 10) < size && i < 10; i++) {
                int index = i + j * 10;
                if (index < 10) {
                    System.out.print(index + " -");
                } else {
                    System.out.print(index + "-");
                }
            }
            System.out.println();
            for (int i = 0; (i + j * 10) < size && i < 10; i++) {
                int index = i + j * 10;
                if (storeArray[index] != "-1") {
                    if (Integer.parseInt(storeArray[index]) < 10) {
                        System.out.print(storeArray[index] + " |");
                    } else {
                        System.out.print(storeArray[index] + "|");
                    }
                } else {
                    System.out.print("  |");
                }
            }
            System.out.println();
        }
    }
}
