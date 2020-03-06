package com.company;

import java.util.ArrayList;

public class HealthyBurger extends BaseHamburger {

    public HealthyBurger(String meatType, double basePrice) {
        super("healthy burger", "black rye bread", meatType, basePrice);
        setAdditionsLimit(6);
    }
}
