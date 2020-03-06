package com.company;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactionList;

    public Customer(String name) {
        this.name = name;
        this.transactionList = new ArrayList<Double>();
    }

    public boolean addTransaction(double transaction){
        transactionList.add(transaction);
        return true;
    }

    public void printTransactions(){
        for(int i=0; i<transactionList.size(); i++){
            System.out.println("(" + (i+1) + ") " + transactionList.get(i).doubleValue());
        }
    }


    public String getName() {
        return name;
    }
}
