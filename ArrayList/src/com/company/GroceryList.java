package com.company;

import java.util.ArrayList;

public class GroceryList {
    ArrayList<String> groceryList = new ArrayList<String>();

    public void addItems(String item) {
        groceryList.add(item);
        System.out.println("Added item " + item);
    }

    public void printItems() {
        System.out.println("Total number of items is " + groceryList.size());
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public void replaceItems(String item, String newItem) {
        int position = groceryList.indexOf(item);
        groceryList.set(position, newItem);
        System.out.println("Replaced No." + (position + 1) + " item " + item + " by " + newItem);
    }

    public void removeItems(int position) {
        if (position < groceryList.size()) {
            System.out.println("Removed item No." + (position + 1) + " " + groceryList.remove(position));
        } else {
            System.out.println("Invalid item position");
        }
    }

    public void removeItems(String item) {
        if (groceryList.contains(item)) {
            int position = groceryList.indexOf(item);
            groceryList.remove(item);
            System.out.println("Removed item No." + (position + 1) + " " + item);
        } else {
            System.out.println("No such item in the list");
        }
    }

    public boolean searchItem(String item) {
        return groceryList.contains(item);
    }

    public int searchItemNo(String item) {
        return groceryList.indexOf(item);
    }
}
