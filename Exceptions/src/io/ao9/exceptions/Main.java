package io.ao9.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x = getInt();
        int y = getInt();
        System.out.println(devide(x, y));
    }

    private static int devide(int x, int y) {
        System.out.println("x is " + x + ", y is " + y);
        try {
            return x / y;
        } catch (ArithmeticException e) {
            System.out.println("Cannot / by zero, returned 0 as result");
            return 0;
        }
    }

    private static int getInt() {
        System.out.println("Please input a number:");
        Scanner s = new Scanner(System.in);
        int input;
        while (true) {
            try {
                input = s.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, try again:");
                s.nextLine();
            }
        }
        return input;
    }


}
