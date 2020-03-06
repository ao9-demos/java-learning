package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bankABC = new Bank("ABC");

    public static void main(String[] args) {
        printInstructions();
        boolean quit = false;
        while (!quit) {
            System.out.println("Press a # for fuctions:");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    addBranch();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    addTransaction();
                    break;
                case 4:
                    printCustomers();
                    break;
                case 9:
                    quit = true;
                    break;
            }
        }
    }

    static void printInstructions() {
        System.out.println("\t Instructions:");
        System.out.println("\t 0. Print instructions");
        System.out.println("\t 1. Add a branch");
        System.out.println("\t 2. Add a customer");
        System.out.println("\t 3. Add a transaction");
        System.out.println("\t 4. Print customers");
        System.out.println("\t 9. Quit");
    }

    static void addBranch() {
        System.out.println("Input a branch name");
        String branchName = scanner.nextLine();

        if (bankABC.addBranch(branchName)) {
            System.out.println("Added branch " + branchName);
        } else {
            System.out.println("Error: branch already exists");
        }
    }

    static void addCustomer() {
        System.out.println("Input which branch to add");
        String branchName = scanner.nextLine();
        int targetBranch = bankABC.findBranch(branchName);
        if (targetBranch >= 0) {
            System.out.println("Input customer name");
            String name = scanner.nextLine();
            int branchOfThisCustomer = bankABC.findCustomer(name);
            if (branchOfThisCustomer >= 0) {
                if (branchOfThisCustomer == targetBranch) {
                    System.out.println("Error: customer already exists in this branch");
                } else {
                    System.out.println("Error: customer already exists in another branch");
                }
            } else {
                System.out.println("Input initial transaction amount $:");
                double initialTransaction = scanner.nextDouble();
                scanner.nextLine();
                bankABC.addCustomer(targetBranch, name, initialTransaction);
                System.out.println("Added customer " + name + " to branch " + bankABC.getBranchName(targetBranch));
            }
        } else {
            System.out.println("Error: no such branch");
        }
    }

    static void addTransaction() {
        System.out.println("Input customer name");
        String name = scanner.nextLine();
        int branchOfThisCustomer = bankABC.findCustomer(name);
        if (branchOfThisCustomer >= 0) {
            System.out.println("Input transaction amount $:");
            double transaction = 0;
            try {
                transaction = scanner.nextDouble();
            } catch (Exception e) {
                e.printStackTrace();
            }
            scanner.nextLine();
            bankABC.addTransaction(branchOfThisCustomer, name, transaction);
            System.out.println("Added transaction");
        } else {
            System.out.println("Error: no such customer");
        }
    }

    static void printCustomers() {
        System.out.println("Input:");
        System.out.println("1 to print all customers");
        System.out.println("2 to print all customers with transactions");
        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.nextLine();

        switch (choice) {
            case 1:
                bankABC.printCustomers(false);
                break;
            case 2:
                bankABC.printCustomers(true);
                break;
            default:
                break;
        }



    }
}
