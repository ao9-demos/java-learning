package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        long average = 0;
        int count = 0;
        boolean first = true;

        while (true) {
            boolean isInt = scanner.hasNextInt();
            if (isInt) {
                int number = scanner.nextInt();

                count++;
                sum += number;
                average = Math.round((double)sum / (double)count);
            } else {
                break;
            }
            scanner.nextLine();
        }
        System.out.println("SUM = " + sum +" AVG = " + average);

        scanner.close();

    }
}
