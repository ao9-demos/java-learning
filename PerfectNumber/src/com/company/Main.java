package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public static boolean isPerfectNumber(int number){
        boolean result = false;
        if(number >= 1){
            int sum = 0;
            for(int i=1; i < number; i++){
                if(number % i == 0){
                    sum += i;
                }
            }
            if (sum == number) {
                result = true;
            }
        }
        return result;
    }
}
