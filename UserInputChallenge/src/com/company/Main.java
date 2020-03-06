package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCount = 1;
        int sum = 0;

        while(numberCount <= 10){
            System.out.println("Enter number #" + numberCount + ":");

            if(scanner.hasNextInt()){
                int inputNumber = scanner.nextInt();
                sum += inputNumber;
                numberCount++;
            } else {
                System.out.println("Invalid number");
            }
            scanner.nextLine();
        }
        scanner.close();
        System.out.println("sum = " + sum);

    }
}
