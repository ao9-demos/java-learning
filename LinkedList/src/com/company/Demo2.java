package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo2 {

    private static LinkedList<String> metroStations = new LinkedList<String>();

    public static void main(String[] args) {


        addInOrder(metroStations, "Guy Concordia");
        addInOrder(metroStations, "Atwater");
        addInOrder(metroStations, "Peel");
        addInOrder(metroStations, "McGill");
        addInOrder(metroStations, "Place-des-Arts");
        addInOrder(metroStations, "McGill");

        printLinkedList(metroStations);


        travelBetweenStations(metroStations);

    }

    private static void printLinkedList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Station " + i.next());

        }
        System.out.println("============");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newStation) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int compares = stringListIterator.next().compareTo(newStation);
            if (compares == 0) {
                System.out.println(newStation + " station already exists");
                return false;
            } else if (compares > 0) {
                stringListIterator.previous();
                stringListIterator.add(newStation);
                return true;
            }
        }
        stringListIterator.add(newStation);
        return true;
    }

    private static void travelBetweenStations(LinkedList<String> linkedList) {
        if (linkedList.isEmpty()) {
            System.out.println("No stations");
            return;
        }
        printInstructions();
        Scanner scanner = new Scanner(System.in);
        ListIterator<String> stringListIterator = linkedList.listIterator();
        int choice = 0;
        boolean movingToNext = true;
        boolean quit = false;
        while (!quit) {
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
                    if (!movingToNext && stringListIterator.hasNext()) {
                        stringListIterator.next();
                        movingToNext = true;
                    }
                    if (stringListIterator.hasNext()) {
                        System.out.println("Travel to " + stringListIterator.next());

                    } else {
                        System.out.println("Final station, can't go next");
                    }
                    break;
                case 2:
                    if (movingToNext && stringListIterator.hasPrevious()) {
                        stringListIterator.previous();
                        movingToNext = false;
                    }

                    if (stringListIterator.hasPrevious()) {

                        System.out.println("Travel to " + stringListIterator.previous());

                    } else {
                        System.out.println("First station, can't go previous");
                    }
                    break;
                case 9:
                    quit = true;
                    break;
            }
        }

    }

    private static void printInstructions() {
        System.out.println("0. instructions");
        System.out.println("1. go next");
        System.out.println("2. go previous");
        System.out.println("9. quit");
    }
}
