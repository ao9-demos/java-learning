package com.company;

public class Cuboid extends Rectangle{
    private double height;

    public Cuboid(double length, double width, double height) {
        super(length, width);
        if (height >= 0) {
            this.height = height;
        } else {
            this.height = 0;
        }
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return getArea() * height;
    }
}
