package com.company;

public class DeluxeBurger extends BaseHamburger {
    public DeluxeBurger(String rollType, String meatType, double basePrice) {
        super("deluxe burger", rollType, meatType, basePrice);
        super.addAdditions(new Chips());
        super.addAdditions(new Drinks());
        setAdditionsLimit(2);
    }
}
