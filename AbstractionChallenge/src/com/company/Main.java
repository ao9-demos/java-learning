package com.company;


import java.awt.*;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        MyLinkedList<String> myLinkedList = new MyLinkedList();
//
//        String stringData = "abc 023 cgg 1ds -1df bdg";
//        String[] strings = stringData.split(" ");
//        for (String s : strings) {
//            myLinkedList.addItem(s);
//        }
//
//        while (myLinkedList.hasRight()) {
//            System.out.println(myLinkedList.right());
//        }
//        System.out.println("===========");
//        while (myLinkedList.hasLeft()) {
//            System.out.println(myLinkedList.left());
//        }
//
//        MyLinkedList<Integer> myIntList = new MyLinkedList<>();
//
//        myIntList.addItem(2);
//        myIntList.addItem(8);
//        myIntList.addItem(1);
//        myIntList.addItem(2);
//        myIntList.addItem(3);
//        myIntList.addItem(5);
//        myIntList.addItem(6);
//        myIntList.addItem(9);
//        myIntList.addItem(0);
//        myIntList.addItem(7);
//        myIntList.addItem(4);
//
//
//
//        myIntList.removeItem(0);
//        myIntList.removeItem(9);
//        myIntList.removeItem(8);
//        myIntList.removeItem(1);
//        myIntList.removeItem(4);
//        myIntList.removeItem(6);
//
//
//        while (myIntList.hasRight()) {
//            System.out.println(myIntList.right());
//        }
//        System.out.println("===========");
//        while (myIntList.hasLeft()) {
//            System.out.println(myIntList.left());
//        }
//        System.out.println("===========");


        BinarySearchTree binarySearchTree = new BinarySearchTree();

        String stringData = "N M G P I J H D F B O C E";
        String[] strings = stringData.split(" ");
        for(String s : strings){
            binarySearchTree.addItem(s);
        }
        System.out.println(binarySearchTree.size());
        binarySearchTree.traverse("N");

        binarySearchTree.removeItem("M");
        binarySearchTree.removeItem("X");
        binarySearchTree.removeItem("G");
        binarySearchTree.removeItem("P");
        binarySearchTree.removeItem("J");




        boolean quit = false;
        while (!quit) {
            System.out.println("Now is " + binarySearchTree.getCurrentValue());

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                e.printStackTrace();
            }
            scanner.nextLine();
            switch (choice){
                case 1:
                    if (binarySearchTree.hasLeft()) {
                        binarySearchTree.left();
                    } else {
                        System.out.println("No left");
                    }
                    break;
                case 2:
                    if (binarySearchTree.hasRight()) {
                        binarySearchTree.right();
                    } else {
                        System.out.println("No right");
                    }
                    break;
                case 3:
                    binarySearchTree.resetCurrentItem();
                    break;
                case 9:
                    quit = true;
                    break;
            }
        }

    }
}
