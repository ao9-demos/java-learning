package com.company;

public class Main {

    public static void main(String[] args) {
        Animal dog = new Dog("woof");
        Animal eagle = new Eagle("eagly");
        Animal penguin = new Penguin("pipi");
        Animal animal = new Animal("what") {
            @Override
            public void breathe() {

            }

            @Override
            public void eat() {

            }
        };

        dog.eat();
        dog.breathe();
        ((Dog) dog).walk();
        eagle.eat();
        penguin.breathe();
        ((Bird) eagle).walk();
        ((Bird) eagle).fly();
        ((Bird) eagle).flyHigh();
        ((Bird) penguin).walk();
        ((Bird) penguin).fly();
        ((Bird) penguin).flyHigh();

        System.out.println(animal.getName());


    }
}
