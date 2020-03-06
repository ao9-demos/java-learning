package com.company;

import java.util.*;

public class Theater {
    private final String theaterName;
    private List<Seat> seats = new LinkedList<>();
    private static final Comparator<Seat> PRICE_ORDER;

    static {
        PRICE_ORDER = new Comparator<>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                return Double.valueOf(seat1.getPrice()).compareTo(seat2.getPrice());
            }
        };
    }

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        double price = 15.0;
        this.theaterName = theaterName;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row < lastRow; row++) {
            for (int i = 1; i <= seatsPerRow; i++) {
                double seatPrice = price;
                if((i > 3) && (seatsPerRow - i >= 3)){
                    seatPrice += 2.0;
                }
                Seat seat = new Seat((row + String.valueOf(i)), seatPrice);
                seats.add(seat);
            }
            if (price > 8.0) {
                price -= 1.0;
            }
        }
    }

    public String getTheaterName() {
        return theaterName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = findSeat(seatNumber);
        if (requestedSeat == null) {
            System.out.println("No such seat " + seatNumber);
            return false;
        } else {
            requestedSeat.reserve();
            return true;
        }
    }

    public boolean cancelSeat(String seatNumber) {
        Seat foundSeat = findSeat(seatNumber);
        if (foundSeat == null) {
            System.out.println("No such seat " + seatNumber);
            return false;
        } else {
            foundSeat.cancel();
            return true;
        }
    }

    private Seat findSeat(String seatNumber){
        Seat seat = new Seat(seatNumber,0.0);
        int seatIndex = Collections.binarySearch(seats,seat,null);
        if (seatIndex >= 0) {
            return seats.get(seatIndex);
        } else {
            return null;
        }
    }


    public void printSeats() {
        for (Seat seat : seats) {
            System.out.print(seat.getSeatNumber() + " $" + seat.getPrice() + " ");
        }
        System.out.println("\n==========================================");
    }

    public void sortPriceOrder(){
        Collections.sort(seats, PRICE_ORDER);
        System.out.println("Sorted as price");
    }

    public void shuffleSeats(){
        Collections.shuffle(seats);
    }

    public void sortSeatsOrder(){
        Collections.sort(seats);
    }

    public void reverseSeats(){
        Collections.reverse(seats);
    }

    private class Seat implements Comparable<Seat> {
        private String seatNumber;
        private double price;
        private boolean reserved = false;

        private Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        private String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
        }

        private boolean reserve() {
            if (!reserved) {
                System.out.println("Seat " + this.seatNumber + " is reserved");
                this.reserved = true;
                return true;
            } else {
                System.out.println("Seat " + this.seatNumber + " can't be reserved, it has been reserved before");
                return false;
            }
        }

        private boolean cancel() {
            if (reserved) {
                System.out.println("Seat " + this.seatNumber + " is cancelled");
                this.reserved = false;
                return true;
            } else {
                System.out.println("Seat " + this.seatNumber + " can't be cancelled, it hasn't been reserved");
                return false;
            }
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}
