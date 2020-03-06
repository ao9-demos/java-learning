package com.company;

import java.util.*;

public class Theater {
    private final String theaterName;
    private List<Seat> seats = new LinkedList<>();

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row < lastRow; row++) {
            for (int i = 1; i <= seatsPerRow; i++) {
                Seat seat = new Seat(row + String.valueOf(i));
                seats.add(seat);
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
        int low = 0;
        int high = seats.size() - 1;
        while(low <= high){
            System.out.print(".");
            int mid = (low + high)/2;
            int cmp = seats.get(mid).getSeatNumber().compareToIgnoreCase(seatNumber);
            if(cmp == 0){
                return seats.get(mid);
            } else if(cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }


    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private static class Seat implements Comparable<Seat> {
        private String seatNumber;
        private boolean reserved = false;

        private Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        private String getSeatNumber() {
            return seatNumber;
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
