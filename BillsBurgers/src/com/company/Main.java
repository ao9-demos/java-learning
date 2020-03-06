package com.company;

public class Main {

    public static void main(String[] args) {
        BaseHamburger chickenBurger = new BaseHamburger("chicken burger", "white bread", "chicken meat", 6.0);
        chickenBurger.addAdditions(new Carrot());
        chickenBurger.addAdditions(new Avocado());
        chickenBurger.addAdditions(new Cucumber());
        chickenBurger.addAdditions(new Eggs());
        chickenBurger.addAdditions(new Lettuce());
        System.out.println(chickenBurger.showPrice());

        HealthyBurger healthyBurger = new HealthyBurger("turkey", 8.0);
        for(int i=0; i<7; i++){
            healthyBurger.addAdditions(randomAdditions());
        }
        System.out.println(healthyBurger.showPrice());

        DeluxeBurger deluxeBurger = new DeluxeBurger("thick bread","ham",12.0);
        deluxeBurger.addAdditions(randomAdditions());
        System.out.println(deluxeBurger.showPrice());
    }

    static Additions randomAdditions() {
        int randomNumber = (int) (Math.random() * 5) + 1;
        switch (randomNumber) {
            case 1:
                return new Carrot();
            case 2:
                return new Avocado();
            case 3:
                return new Cucumber();
            case 4:
                return new Eggs();
            case 5:
                return new Lettuce();
            default:
                return null;
        }
    }
}
