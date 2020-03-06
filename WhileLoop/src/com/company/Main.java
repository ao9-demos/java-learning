package com.company;

public class Main {

    public static void main(String[] args) {
        int count = 1;
        while (count != 6) {
            System.out.println("count = " + count);
            count++;
        }
        count = 1;
        while (true) {
            if (count == 6) {
                break;
            }
            System.out.println("count = " + count);
            count++;
        }
        count = 1;
        do {
            System.out.println("count = " + count);
            count++;
        } while (count != 6);

        int number = 4;
        int finishNumber = 20;
        count = 0;
        while (number <= finishNumber){
            number++;
            if(!isEvenNumber(number)){
                continue;
            }
            System.out.println("number = " + number);
            count++;
            if (count == 5) {
                System.out.println("count = " + count);
                break;
            }
        }

    }

    public static boolean isEvenNumber(int number){
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
