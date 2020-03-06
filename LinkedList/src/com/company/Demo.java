package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Demo {

    private static LinkedList<String> metroStations = new LinkedList<String>();

    public static void main(String[] args) {
        metroStations.add("Atwater");
        metroStations.add("Guy Concordia");
        metroStations.add("Peel");
        metroStations.add("McGill");

        printLinkedList(metroStations);

        metroStations.add(2,"def");
        metroStations.addFirst("abc");
        metroStations.addLast("abc");
        printLinkedList(metroStations);

        metroStations.remove("abc");
        metroStations.remove(2);
        printLinkedList(metroStations);
    }

    private static void printLinkedList(LinkedList linkedList){
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext()) {
            System.out.println("Station " + i.next());

        }
        System.out.println("============");
    }
}
