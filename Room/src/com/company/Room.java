package com.company;

public class Room {
    private Floor floor;
    private Window window;
    private TV myTV;

    public Room(Floor floor, Window window, TV myTV) {
        this.floor = floor;
        this.window = window;
        this.myTV = myTV;
    }

    public void turnOnFloorHeating(){
        floor.turnOnHeating();
    }

    private Floor getFloor() {
        return floor;
    }

    public Window getWindow() {
        return window;
    }

    public TV getMyTV() {
        return myTV;
    }
}
