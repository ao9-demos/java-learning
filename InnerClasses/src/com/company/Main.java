package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Button button = new Button("Start");

    public static void main(String[] args) {

//        class ClickListener implements Button.OnClickListner {
//            public ClickListener() {
//                System.out.println("Initialed");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " is clicked");
//            }
//        }
//        button.setOnClickListner(new ClickListener());
        button.setOnClickListner(new Button.OnClickListner() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " is clicked");
            }
        });


        listen();
    }

    private static void listen(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        boolean quit = false;
        while (!quit) {
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    button.onClick();
                    break;
                case 2:
                    quit = true;
                    break;
            }
        }
    }
}
