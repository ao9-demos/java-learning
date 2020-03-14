package io.ao9.exceptions;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(divide());
        } catch (ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Cannot perform the divide");;
        }
    }

    private static int divide() {
//        try {
            int x = getInt();
            int y = getInt();
            System.out.println("x is " + x + ", y is " + y);
            return x / y;
//        } catch (ArithmeticException e) {
//            throw new ArithmeticException("cannot / by 0");
//        } catch (NoSuchElementException e) {
//            throw new ArithmeticException("No such element");
//        }
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
