package com.company;

public class Main {

    public static void main(String[] args) {
	Lambo myCar = new Lambo();
	myCar.setSpeed(100);
	myCar.changeGear(5);
	myCar.move();
	myCar.setTurboIsOn(true);
        myCar.move(120);
    }
}
