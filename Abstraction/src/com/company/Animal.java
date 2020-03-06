package com.company;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void breathe();
    public abstract void eat();

    public String getName() {
        return name;
    }
}
