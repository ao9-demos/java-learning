package com.company;

public class VIPCustomer {
    String name;
    double creditLimit;
    String email;

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public VIPCustomer() {
        this("Default name", 1000.0, "Default email");
    }

    public VIPCustomer(String name, String email) {
        this(name, 1000.0, email);
    }

    public VIPCustomer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }
}
