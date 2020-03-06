package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 0;
        int max = 0;
        int count = 0;
        while (true) {
            System.out.println("Enter your number");

            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (count == 0) {
                    min = number;
                    max = number;
                } else if (number < min) {
                    min = number;

                } else if (number > max) {
                    max = number;

                }
                count++;
                System.out.println("min = " + min);
                System.out.println("max = " + max);
            } else {
                break;
            }
            scanner.nextLine();
        }
        if (count == 0) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("Mini number = " + min);
            System.out.println("Max number = " + max);
        }
        scanner.close();
    }
}
