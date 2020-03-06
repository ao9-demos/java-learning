package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(150, 800, 800);
        Case myCase = new Case("gameCase", "Huawei", "800kw", dimensions);
        MotherBoard myMotherBoard = new MotherBoard("gameBoard", "Huawei", "someBios", 8, 6);
        Resolution resolution = new Resolution(3000, 2000);
        Monitor myMonitor = new Monitor("gameMonitor", "AOC", 32, resolution);
        PC myPc = new PC(myCase, myMonitor, myMotherBoard);
        PC2 myPc2 = new PC2(myCase, myMonitor, myMotherBoard);

       myPc.getTheCase().pressPowerButton();
        myPc.getMonitor().drawPixelAt(12,500,"red");
        myPc.getMotherBoard().loadProgram("Diablo");

        myPc2.powerUp();

    }
}
