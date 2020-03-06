package com.company;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater("Plaza Theater",8,8);
        List<Theater.Seat> seats = theater.getSeats();
        List<Theater.Seat> seatsCopy = new LinkedList<>(seats);
//        shallow copy

        printSeats(seats);
        printSeats(seatsCopy);

        seatsCopy.get(1).reserve();
        theater.reserveSeat("A2");

        Collections.shuffle(seatsCopy);
        printSeats(seats);
        printSeats(seatsCopy);

        sortSeats(seatsCopy);
        printSeats(seatsCopy);




    }

    private static void printSeats(List<? extends Theater.Seat> seats) {
        for (Theater.Seat seat : seats) {
            System.out.print(seat.getSeatNumber() + " ");
        }
        System.out.println("\n ======================================================");
    }

    private static void sortSeats(List<? extends Theater.Seat> seats) {
        for(int i=0; i<seats.size()-1; i++){
            for(int j=i+1; j<seats.size(); j++){
                if(seats.get(i).compareTo(seats.get(j)) > 0){
                    Collections.swap(seats, i, j);
                }
            }
        }
    }
}
