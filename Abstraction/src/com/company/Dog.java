package com.company;

public class Dog extends Animal implements CanWalk {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " is breathing...");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating dog food");

    }

    @Override
    public void walk() {
        System.out.println(getName() + " is walking like a dog");
    }
}
