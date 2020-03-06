package com.company;

public class SomeClass {
    private static int classCount;
    public final int idNumber;
    private final String name;

    public SomeClass(String name) {
        this.name = name;
        this.classCount++;
        this.idNumber = this.classCount;
        System.out.println(this.name + " " + this.idNumber);
    }
}
