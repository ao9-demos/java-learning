package com.company;

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("eats nothing");
    }

    public String getName() {
        return name;
    }
}

class Dog extends Animal{
    public Dog() {
        super("The Dog");
    }

    @Override
    public void eat() {
        System.out.println("eats dog food");
    }
}

class Cat extends Animal {
    public Cat() {
        super("The Cat");
    }

    @Override
    public void eat() {
        System.out.println("eats cat food");
    }
}

class Bird extends Animal {
    public Bird() {
        super("The Bird");
    }

    @Override
    public void eat() {
        System.out.println("eats bird food");
    }
}

class Fish extends Animal {
    public Fish() {
        super("The fish");
    }

    // no eat method
}

public class Main {

    public static void main(String[] args) {
        for (int i=0; i <= 10; i++) {
            Animal randomAnimal = randomAnimal();
            System.out.print(randomAnimal.getName() + " ");
            randomAnimal.eat();
        }
    }

    public static Animal randomAnimal(){
        int randomNumber = (int) (Math.random() * 4) + 1;
        switch (randomNumber) {
            case 1:
                return new Dog();
            case 2:
                return new Cat();
            case 3:
                return new Bird();
            case 4:
                return new Fish();
        }
        return null;
    }
}
