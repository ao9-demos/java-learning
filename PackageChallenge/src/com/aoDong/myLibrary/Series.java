package com.aoDong.myLibrary;

public class Series {
    public static long nSum(int n){
        long result = 0;
        if(n < 0){
            System.out.println("Error: n can't be negative");
            result = -1;
        } else{
            while (n > 0) {
                result += n;
                n--;
            }
        }
        return result;
    }

    public static long factorial(int n){
        long result = 1;
        if(n < 0){
            System.out.println("Error: n can't be negative");
            result = -1;
        } else{
            while (n > 0) {
                result *= n;
                n--;
            }
        }
        return result;
    }

    public static long fibonacci(int n){
        long result = 1;
        if(n < 0){
            System.out.println("Error: n can't be negative");
            result = -1;
        } else if(n <= 1){
            result = n;
        } else {
            result = fibonacci(n-1) + fibonacci(n-2);
        }
        return result;
    }
}
