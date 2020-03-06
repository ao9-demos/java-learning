package com.company;

import java.security.PrivateKey;

public class Fish extends Animal {
    private int gills;
    private int eyes;
    private int fins;

    public Fish(){

    }

    public Fish(String name, int size, int weight, int gills, int eyes, int fins) {
        super(name, 1, 1, size, weight);
        this.gills = gills;
        this.eyes = eyes;
        this.fins = fins;
    }

    private void rest(){

    }

    private void moveMuscles(){
        System.out.println("Muscles moved");
    }

    private void moveBackFin(){
        System.out.println("BackFin moved");
    }

    public void swim(int speed){
        moveMuscles();
        moveBackFin();
        super.move(speed);
    }

    @Override
    public void move(int speed) {
        System.out.println("Fish.move() called");
        moveMuscles();
        moveBackFin();
        super.move(speed);
    }

    @Override
    public void move() {
        System.out.println("Fish.move() called");
        super.move();
    }
}
