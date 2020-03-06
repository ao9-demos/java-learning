package com.company;

public class Vehicle {
//    private int gearLevel;
    public String name;
    public int size;
    public int speed;

//    public Vehicle(String name, int size, int speed){
//        this.name = name;
//        this.size = size;
//        this.speed = speed;
//    }


    public Vehicle(String name, int size, int speed) {
        this.name = name;
        this.size = size;
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move() {
        System.out.println("The vehicle is moving at speed " + this.speed);
    }

    public void move(int speed) {
        this.speed = speed;
        System.out.println("The vehicle is moving at speed " + this.speed);
    }
}
