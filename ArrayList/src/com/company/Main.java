package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        printInstructions();
        while (!quit) {

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    addItem();
                    break;
                case 2:
                    replaceItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    groceryList.printItems();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    break;
            }
        }

    }

    static void printInstructions(){
        System.out.println("\nInstructions");
        System.out.println("\t 0. print instructions");
        System.out.println("\t 1. add an item");
        System.out.println("\t 2. replace an item");
        System.out.println("\t 3. remove an item");
        System.out.println("\t 4. print the list");
        System.out.println("\t 5. search an item");
        System.out.println("\t 6. quit");
    }

    static void addItem(){
        System.out.println("Input an item you want to add:");
        String item = scanner.nextLine();
        groceryList.addItems(item);
    }

    static void replaceItem(){
        String item = null;
        while (true) {
            System.out.println("Input the item you want to replace");
            System.out.println("Or input exit to stop replacing");
            item = scanner.nextLine();
            if(groceryList.searchItem(item)){
                System.out.println("Input the new item");
                String newItem = scanner.nextLine();
                groceryList.replaceItems(item, newItem);
                break;
            } else if(item.equals("exit")) {
                System.out.println("Stopped replacing");
                break;
            } else {
                System.out.println("No such item.");
            }
        }

    }

    static void removeItem(){
        System.out.println("Removing item:");
        System.out.println("1. input item #");
        System.out.println("2. to input item name");
        System.out.println("3. back");
        int input = scanner.nextInt();
        scanner.nextLine();
        switch (input){
            case 1:
                System.out.println("In put item #:");
                int itemNo = scanner.nextInt();
                scanner.nextLine();
                groceryList.removeItems(itemNo-1);
                break;
            case 2:
                System.out.println("In put item name:");
                String item = scanner.nextLine();;
                groceryList.removeItems(item);
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid input");
                break;

        }

    }

    static void searchItem(){
        System.out.println("Input the item you want to search");
        String item = scanner.nextLine();
        if(groceryList.searchItem(item)){
            System.out.println("This item is in the list");
            System.out.println("It is the No." + (groceryList.searchItemNo(item)+1) + " item");
        } else {
            System.out.println("This item is not in the list");
        }

    }


}
