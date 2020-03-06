package com.company;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println(getName() +  " can't fly...can swim");
    }

    @Override
    public void flyHigh() {
        System.out.println(getName() +  " can't fly high");
    }
}
