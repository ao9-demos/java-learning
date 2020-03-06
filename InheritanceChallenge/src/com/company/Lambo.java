package com.company;

public class Lambo extends Car {
    private boolean turboIsOn;

    public Lambo(String name, int size, int speed, int gearLevel, boolean turboIsOn) {
        super(name, size, speed, gearLevel);
        this.turboIsOn = turboIsOn;
    }

    public boolean isTurboIsOn() {
        return turboIsOn;
    }

    public void setTurboIsOn(boolean turboIsOn) {
        this.turboIsOn = turboIsOn;
    }

    public void move(){
        super.move();
        if (turboIsOn) {
            System.out.println("with turbo ON!");
        } else {
            System.out.println("with turbo OFF!");
        }
    }

    public void move(int speed){
        super.move(speed);
        if (turboIsOn) {
            System.out.println("with turbo ON!");
        } else {
            System.out.println("with turbo OFF!");
        }
    }

}
