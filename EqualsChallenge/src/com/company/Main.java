package com.company;

public class Main {

    public static void main(String[] args) {
        Dog rover1 = new Dog("Rover");
        Labrador rover2 = new Labrador("Rover");
        System.out.println(rover1.equals(rover2));
        System.out.println(rover2.equals(rover1));

        System.out.println(rover1 instanceof Dog);
        System.out.println(rover2 instanceof Dog);
        System.out.println(rover1.getClass());
        System.out.println(rover2.getClass());
        System.out.println(rover1.getClass() == rover2.getClass());


    }
}
