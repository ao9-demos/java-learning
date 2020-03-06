package com.company;

import java.util.ArrayList;

public class BaseHamburger {
    private String burgerName;
    private String rollType;
    private String meatType;
    private double basePrice;
    private double totalPrice;
    private int additionsLimit;
    private int additionsCount;
    private ArrayList<Additions> additionsList;

    public BaseHamburger(String burgerName, String rollType, String meatType, double basePrice) {
        this.burgerName = burgerName;
        this.rollType = rollType;
        this.meatType = meatType;
        this.basePrice = basePrice;
        this.additionsLimit = 4;
        this.additionsCount = 0;
        this.totalPrice = basePrice;
        this.additionsList = new ArrayList<Additions>();
    }

    public void addAdditions(Additions additions){
        if (additionsCount < additionsLimit) {
            additionsList.add(additions);
            System.out.println(additions.getName() + " added");
            totalPrice += additions.getPrice();
            additionsCount += 1;
        } else {
            System.out.println("reached limit of additions, cannot add more");
        }
    }

    public String showPrice(){
        String message = "It's " + burgerName + " with " + rollType + " and " + meatType + " at $" + basePrice + ",\n";
        for(int i=0; i < additionsList.size(); i++){
            message += "with additions of " + additionsList.get(i).getName() + " at $" + additionsList.get(i).getPrice() + ",\n";
        }
        message += "and the total price is $" + totalPrice;

        return message;
    }

    public void setAdditionsLimit(int additionsLimit) {
        this.additionsLimit = additionsLimit;
    }
}
