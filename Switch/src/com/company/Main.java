package com.company;

public class Main {

    public static void main(String[] args) {
        int switchValue = 3;

        switch (switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Value was 3, 4 or 5");
                break;
            default:
                System.out.println("Value was not 1, 2, 3, 4 or 5");
                break;
        }

        char switchCharValue = 'A';
        switch (switchCharValue) {
            case 'A':
                System.out.println("Value was A");
                break;
            case 'B':
                System.out.println("Value was B");
                break;
            case 'C': case 'D': case 'E':
                System.out.println("Value was C, D or E");
                break;
            default:
                System.out.println("Value was not A, B, C, D or E");
                break;
        }
    }
}
