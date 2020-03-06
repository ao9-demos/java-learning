package com.company;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;

    public BankAccount(String accountNumber, double balance, String customerName, String email, String phoneNumber){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Constructor called with parameters");
    }

    public BankAccount() {
        this("56789", 2.5, "Default name", "Default address", "Default number");
        System.out.println("Empty constructor called");
    }

    public BankAccount(String customerName, String email, String phoneNumber) {
        this("9999", 2.50, customerName, email, phoneNumber);
    }

    public String getAccountNumber() {
        return accountNumber;

    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double number){
        if (number > 0) {
            this.balance += number;
            System.out.println("Deposited $" + number + ", and the new balance is $" + this.balance);
        } else {
            System.out.println("Invalid value");
        }
    }

    public void withdraw(double number){
        if(number <= 0){
            System.out.println("Invalid value");
        } else if(number <= this.balance){
            this.balance -= number;
            System.out.println("Withdrew $" + number + ", and the new balance is $" + this.balance);
        } else {
            System.out.println("Not enough balance");
        }
    }
}
