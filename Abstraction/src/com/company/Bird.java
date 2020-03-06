package com.company;

public abstract class Bird extends Animal implements CanFly, CanWalk {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " is breathing...as a bird");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating bird food");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flapping wings");
    }

    @Override
    public void walk() {
        System.out.println(getName() + " is walking...as a bird");
    }
}
