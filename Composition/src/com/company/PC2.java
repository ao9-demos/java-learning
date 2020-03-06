package com.company;

public class PC2 {
    private Case theCase;
    private Monitor monitor;
    private MotherBoard motherBoard;

    public PC2(Case theCase, Monitor monitor, MotherBoard motherBoard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherBoard = motherBoard;
    }

    public void powerUp(){
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo(){
        monitor.drawPixelAt(1000,1000,"Yellow");
    }
}
