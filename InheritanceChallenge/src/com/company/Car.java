package com.company;

public class Car extends Vehicle {
    public int gearLevel;

    public Car(String name, int size, int speed, int gearLevel) {
        super(name, size, speed);
        this.gearLevel = gearLevel;
    }

    public int getGearLevel() {
        return gearLevel;
    }

    public void changeGear(int gearLevel) {
        this.gearLevel = gearLevel;
        System.out.println("The gear of the car is now level " + this.gearLevel);
    }


}
