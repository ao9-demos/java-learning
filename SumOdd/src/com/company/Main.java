package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(sumOdd(1,100));
        System.out.println(sumOdd(-1,100));
        System.out.println(sumOdd(100,100));
        System.out.println(sumOdd(13,13));
        System.out.println(sumOdd(100,-100));
        System.out.println(sumOdd(100,1000));
    }

    public static boolean isOdd(int number) {
        boolean result = false;
        if (number > 0) {
            if (number % 2 != 0) {
                result = true;
            }
        }
        return result;
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;

        if (start > 0 && end >= start) {
            for(int i=start; i<=end; i++) {
                if (isOdd(i)) {
                    sum += i;
                }
            }
            return sum;
        } else {
            return -1;
        }

    }
}
