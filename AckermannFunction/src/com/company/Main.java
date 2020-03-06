package com.company;

public class Main {
    static int count;
    public static void main(String[] args) {
        System.out.println(ackermannFunction(3, 3));
    }

    private static long ackermannFunction(long m, long n) {
        if (m == 0) {
            System.out.println("a. " + (count++) + "m" + m + "n" + n);
            return n + 1;
        }
        if (n == 0) {
            System.out.println("b. " + (count++) + "m" + m + "n" + n);
            return ackermannFunction(m - 1, 1);
        }

        System.out.println("c. " + (count++) + "m" + m + "n" + n);
        return ackermannFunction(m - 1, ackermannFunction(m, n - 1));

    }
}
