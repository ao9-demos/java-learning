package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
        System.out.println(isPalindrome(-10101));
        System.out.println(isPalindrome(22));
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(-8));
        System.out.println(isPalindrome(3456543));
    }

    public static boolean isPalindrome(int number){
        if(number > -10 && number < 10){
            return true;
        }
        int reverse = 0;
        int a = number;
        int b = 0;
        while (a != 0) {
            b = a % 10;
            a = (int) (a / 10);
            reverse = reverse * 10 + b;
        }
        if (reverse == number) {
            return true;
        }
        return false;
    }
}
