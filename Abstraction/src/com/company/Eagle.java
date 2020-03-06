package com.company;

public class Eagle extends Bird {
    public Eagle(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println(getName() + " is flying in the sky");
    }
}
