package com.company;

public class Main {

    public static void main(String[] args) {
	String string1 = "This is a";
	String string2 = string1 + " string!";
        System.out.println("string2 = " + string2);

    String string3 = string2 + " \u00A9 2019";
        System.out.println("string3 = " + string3);
    
    String string4 = "1312";
    String string5 = string4 + "1111" + 2222 + 3333.3333;
        System.out.println("string5 = " + string5);
    }
}
