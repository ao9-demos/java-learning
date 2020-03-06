package com.company;

import java.util.ArrayList;

public class Branch {
    private String branchName;
    private ArrayList<Customer> customerList;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customerList = new ArrayList<Customer>();
    }

    public void addCustomer(String name, double initialTransaction) {
        Customer customer = new Customer(name);
        customer.addTransaction(initialTransaction);
        customerList.add(customer);

    }

    public void addTransaction(String name, double transaction){
        int customerPosition = findCustomer(name);
        customerList.get(customerPosition).addTransaction(transaction);
    }

    public void printCustomers(boolean printTransactions) {
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println((i + 1) + ". " + customerList.get(i).getName());
            if (printTransactions) {
                customerList.get(i).printTransactions();
            }
        }
    }

    public int findCustomer(String name) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public String getBranchName() {
        return branchName;
    }
}
