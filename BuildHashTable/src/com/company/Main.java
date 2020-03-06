package com.company;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(30);
        String[] stringToStore = {"90", "60", "30", "62", "97", "78"};
        hashTable.add2(stringToStore);
        hashTable.print();
        System.out.println(hashTable.get2("67"));
        System.out.println(hashTable.get2("60"));
        System.out.println(hashTable.get2("90"));
        System.out.println(hashTable.get2("30"));
        System.out.println(hashTable.get2("62"));
        System.out.println(hashTable.get2("97"));
        System.out.println(hashTable.get2("167"));
        System.out.println(hashTable.get2("267"));
        System.out.println(hashTable.get2("367"));


    }
}
