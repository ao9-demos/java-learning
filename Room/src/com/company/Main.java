package com.company;

public class Main {

    public static void main(String[] args) {
	TheArea floorArea = new TheArea(500,800);
	Floor floor = new Floor("Brown",false,floorArea);
	TheArea windowArea = new TheArea(50, 80);
	Window window = new Window(windowArea,false);
	Dimensions dimensions = new Dimensions(5,150,80);
	TV myTV = new TV("Sony",12,dimensions);
	Room room = new Room(floor,window,myTV);

	room.turnOnFloorHeating();
	room.getMyTV().changeVolume(11);
	room.getWindow().openWindow();

    }
}
