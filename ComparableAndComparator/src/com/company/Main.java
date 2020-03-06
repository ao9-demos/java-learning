package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater("Plaza Theater", 8, 8);
        theater.reserveSeat("B12");
        theater.reserveSeat("D8");

        theater.printSeats();

        theater.sortPriceOrder();
        theater.printSeats();

        theater.sortSeatsOrder();
        theater.printSeats();

        theater.shuffleSeats();
        theater.printSeats();

        theater.sortSeatsOrder();
        theater.printSeats();

        theater.reverseSeats();
        theater.printSeats();


    }
}
