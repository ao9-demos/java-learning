package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contactArrayList = new ArrayList<Contact>();

    public void storeContact(String name, String phoneNumber) {
        Contact contact = new Contact(name, phoneNumber);
        contactArrayList.add(contact);
        System.out.println("New contact " + contact.getName() + " stored");

    }

    public void modifyContact(int position, Contact newContact) {
        contactArrayList.set(position, newContact);
        System.out.println("Contact " + newContact.getName() + " modified");
    }

    public void removeContact(String name) {
        int position = containContact(name);
        if (position >= 0) {
            String contactName = contactArrayList.get(position).getName();
            contactArrayList.remove(position);
            System.out.println("Contact " + contactName + " removed");
        } else {
            System.out.println("No such contact");
        }
    }

    public int containContact(String name) {
        for (int i = 0; i < contactArrayList.size(); i++) {
            Contact currentContact = contactArrayList.get(i);
            if (currentContact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }


    public void queryContact(String name) {
        int position = containContact(name);
        if (position >= 0) {
            String phoneNumber = contactArrayList.get(position).getPhoneNumber();
            System.out.println("The number of the contact is " + phoneNumber);
        } else {
            System.out.println("No such contact");
        }
    }

    public void printContactList() {
        for (int i = 0; i < contactArrayList.size(); i++) {
            System.out.println((i + 1) + ". " + contactArrayList.get(i).getName() + " - " + contactArrayList.get(i).getPhoneNumber());
        }
    }

}
