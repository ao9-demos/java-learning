package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println(getLargestPrime(16));
    }

    public static int getLargestPrime(int number) {
        if (number <= 1) {
            return -1;
        }
        int largestPrime = 0;

        for (int i = number; i > 1; i--) {
            System.out.println("i = " + i);
            if (number % i == 0) {
                if (i == 2 || i == 3) {
                    return i;
                }
                for(int j=2; j<=Math.sqrt(i); j++){
                    System.out.println("j = " + j);
                    if(i % j != 0){
                        largestPrime = i;;
                    } else {
                        largestPrime = 0;
                        break;
                    }
                    System.out.println("largestPrime = " + largestPrime);
                }
                if(largestPrime != 0){
                    break;
                }
            }

        }
        return largestPrime;

    }

}
