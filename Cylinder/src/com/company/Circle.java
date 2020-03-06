package com.company;

public class Circle {
    private double radius;

    public Circle(double radius) {

        if (radius >= 0) {
            this.radius = radius;
        } else {
            this.radius = 0;
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    private int test = 0;
}
