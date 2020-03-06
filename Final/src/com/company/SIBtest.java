package com.company;

public class SIBtest {
    private static final String name;

    static {
        name = "DA";
        System.out.println("static initialization block called");
    }

    public SIBtest() {
        System.out.println("constructor called");
    }

    static {
        System.out.println("SIB no.2 called");
    }

    public void someMethod(){
        System.out.println("some method called");
    }
}
