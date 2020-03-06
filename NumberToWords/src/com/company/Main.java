package com.company;

public class Main {

    public static void main(String[] args) {
        numberToWords(5020);

    }

    public static void numberToWords(int number){
        if (number < 0) {
            System.out.println("Invalid Value");
        } else {
            int reverseNumber = reverse(number);
            int count = 0;
            while(reverseNumber > 0){
                int lastDigit = reverseNumber % 10;
                String lastDigitWord = null;
                switch (lastDigit){
                    case 1:
                        lastDigitWord = "One";
                        break;
                    case 2:
                        lastDigitWord = "Two";
                        break;
                    case 3:
                        lastDigitWord = "Three";
                        break;
                    case 4:
                        lastDigitWord = "Four";
                        break;
                    case 5:
                        lastDigitWord = "Five";
                        break;
                    case 6:
                        lastDigitWord = "Six";
                        break;
                    case 7:
                        lastDigitWord = "Seven";
                        break;
                    case 8:
                        lastDigitWord = "Eight";
                        break;
                    case 9:
                        lastDigitWord = "Nine";
                        break;
                    case 0:
                        lastDigitWord = "Zero";
                        break;
                }
                System.out.println(lastDigitWord);
                reverseNumber /= 10;
                count++;
            }
            for(int i=count; i<getDigitCount(number); i++){
                System.out.println("Zero");
            }

        }
    }

    public static int reverse(int number){
        int reverse = 0;
        if (number > -10 && number < 10) {
            reverse = number;
        } else {
            while(number != 0){
                reverse = (reverse * 10) + (number % 10);
                number /= 10;
            }
        }
        return reverse;
    }

    public static int getDigitCount(int number){
        if (number < 0) {
            return -1;
        } else if(number == 0) {
            return 1;
        } else {
            return ((int) Math.log10(number) + 1);
        }
    }
}
