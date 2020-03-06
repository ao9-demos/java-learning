package com.company;

public class Main {

    public static void main(String[] args) {
	Printer printer = new Printer(60,true);
	printer.fillUpToner(-30);
	printer.fillUpToner(30);
	printer.print(12);
	printer.print(-2);
	printer.print(11);
    }
}
