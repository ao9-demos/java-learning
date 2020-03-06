package com.company;

public interface CanFly {
    void fly();

    default void flyHigh(){
        System.out.println("high in the sky!");
    }
}
