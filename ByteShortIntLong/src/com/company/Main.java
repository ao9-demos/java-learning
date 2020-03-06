package com.company;

public class Main {

    public static void main(String[] args) {
        int intMini = -2_147_483_648;
        int intMax = 2_147_483_647;
        int newInt = intMax/2;
        System.out.println("newInt = " + newInt);

        byte byteMini = -128;
        byte byteMax = 127;
        byte newByte = (byte) (byteMax/2);
        System.out.println("newByte = " + newByte);

        short shortMini = -32768;
        short shortMax = 32767;
        short newShort = (short)(shortMax/2);
        System.out.println("newShort = " + newShort);

        long longTotal = 5000L + 10L * (newInt + newByte + newShort);
        System.out.println("longTotal = " + longTotal);
    }
}
