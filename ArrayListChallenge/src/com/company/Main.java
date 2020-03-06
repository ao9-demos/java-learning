package com.company;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        printInstructions();
        boolean quit = false;
        while (!quit) {
            System.out.println("Input the # of function:");

            int input = 0;
            try {
                input = scanner.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }
            scanner.nextLine();

            switch (input) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    addContact();
                    break;
                case 2:
                    modifyContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    queryContact();
                    break;
                case 5:
                    mobilePhone.printContactList();
                    break;
                case 6:
                    quit = true;
                    break;
            }


        }
    }

    static void printInstructions() {
        System.out.println("\n\t Instructions");
        System.out.println("\t 0. print instructions");
        System.out.println("\t 1. add contact");
        System.out.println("\t 2. modify contact");
        System.out.println("\t 3. remove contact");
        System.out.println("\t 4. query contact");
        System.out.println("\t 5. print all contacts");
        System.out.println("\t 6. quit");
    }

    static void addContact() {

        while (true) {
            System.out.println("Input contact name you want to add:");
            String name = scanner.nextLine();
            int position = mobilePhone.containContact(name);
            if (position < 0) {
                System.out.println("Input contact phone number:");
                String phoneNumber = scanner.nextLine();
                mobilePhone.storeContact(name, phoneNumber);
                break;
            } else {
                System.out.println("Contact name already exists");
            }
        }
    }

    static void modifyContact() {
        System.out.println("Input contact name you want to modify:");

        String name = scanner.nextLine();
        int position = mobilePhone.containContact(name);
        if (position >= 0) {
            while (true) {
                System.out.println("Input new name\ninput nothing to keep the old name:");
                String newName = scanner.nextLine();
                int newPosition = mobilePhone.containContact(newName);

                if (newPosition < 0) {
                    if(newName.equals("")){
                        newName = name;
                    }
                    System.out.println("Input new contact phone number:");
                    String newPhoneNumber = scanner.nextLine();
                    Contact newContact = new Contact(newName, newPhoneNumber);
                    mobilePhone.modifyContact(position, newContact);
                    break;
                } else {
                    System.out.println("Contact name already exists");
                }
            }

        } else {
            System.out.println("Contact name does not exist");
        }

    }

    static void removeContact() {
        System.out.println("Input contact name you want to remove:");

        String name = scanner.nextLine();
        mobilePhone.removeContact(name);
    }

    static void queryContact() {
        System.out.println("Input contact name you want to query:");

        String name = scanner.nextLine();
        mobilePhone.queryContact(name);
    }
}
