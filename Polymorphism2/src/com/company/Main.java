package com.company;

class Car {
    private String name;
    private boolean hasEngine;
    private int cylinders;
    private int wheels;

    public Car(String name, int cylinders) {

        this.name = name;
        if (cylinders >= 2 && cylinders <= 20) {
            this.cylinders = cylinders;
        } else {
            this.cylinders = 4;
        }
        this.hasEngine = true;
        this.wheels = 4;
    }

    public String startEngine(){
        return this.name + " starts engine with " + cylinders + " cylinders";
    }

    public String accelerate(){
        return this.name + " speed up with " + wheels + " wheels";
    }

    public String brake(){
        return this.name + " slow down";
    }

    public String getName() {
        return name;
    }

    public boolean isHasEngine() {
        return hasEngine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }
}

class Toyota extends Car {
    public Toyota(int cylinders) {
        super("Toyota", cylinders);
    }
}

class Benz extends Car {
    public Benz(int cylinders) {
        super("Benz", cylinders);
    }
}

class Honda extends Car {
    public Honda(int cylinders) {
        super("Honda", cylinders);
    }

    @Override
    public String brake() {
        return super.brake() +". " + getClass().getSimpleName() +" stopped.";
    }
}

public class Main {

    public static void main(String[] args) {
	for(int i=0; i < 10; i++){
	    Car car = randomCar();
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());
    }
    }

    static Car randomCar(){
        int randomNumber = (int) (Math.random() * 3) + 1;
        switch(randomNumber){
            case 1:
                return new Toyota(4);
            case 2:
                return new Benz(8);
            case 3:
                return new Honda(6);
        }
        return null;
    }


}
