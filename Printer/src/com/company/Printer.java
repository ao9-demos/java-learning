package com.company;

public class Printer {
    private int tonerLevel;
    private int printedPaper;
    private boolean isDuplex;

    public Printer(int tonerLevel,  boolean isDuplex) {
        if (tonerLevel >=0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }

        this.printedPaper = 0;

        this.isDuplex = isDuplex;
    }

    public void fillUpToner(int fillPercentage) {
        if(fillPercentage > 0) {
            tonerLevel += fillPercentage;
            if(tonerLevel > 100){
                tonerLevel = 100;
            }
            System.out.println("Toner is filled to " + tonerLevel + "%");
        } else {
            System.out.println("Invalid value. Toner is not filled and is remained at " + tonerLevel + "%");
        }
    }

    public void print(int printngNumber) {
        if (printngNumber > 0) {
            System.out.println("Printing " + printngNumber + " papers");
            printedPaper += printngNumber;
            System.out.println(printedPaper + " papers has been printed");
        } else {
            System.out.println("Invalid value. Nothing is printed");
        }

    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPrintedPaper() {
        return printedPaper;
    }

    public boolean isDuplex() {
        return isDuplex;
    }
}
