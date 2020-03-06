package com.company;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Branch> branchList;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branchList = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) < 0) {
            Branch branch = new Branch(branchName);
            branchList.add(branch);
            return true;
        } else {
            return false;
        }
    }

    public void addCustomer(int targetBranch, String name, double initialTransaction) {
        branchList.get(targetBranch).addCustomer(name,initialTransaction);
    }

    public void addTransaction(int targetBranch, String name, double transaction){
        branchList.get(targetBranch).addTransaction(name,transaction);
    }

    public void printCustomers(boolean printTransactions){
        for(int i=0; i<branchList.size(); i++){
            System.out.println("In branch " + branchList.get(i).getBranchName());
            branchList.get(i).printCustomers(printTransactions);
        }
    }

    public int findCustomer(String name) {
        for (int i = 0; i < branchList.size(); i++) {
            if (branchList.get(i).findCustomer(name) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public int findBranch(String branchName) {
        for (int i = 0; i < branchList.size(); i++) {
            if (branchList.get(i).getBranchName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }

    public String getBranchName(int branchPosition){
        return branchList.get(branchPosition).getBranchName();
    }

    public String getBankName() {
        return bankName;
    }
}
