package com.company;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        if (height >= 0) {
            this.height = height;
        } else {
            this.height = 0;
        }
    }

    public void setRadius(double radius) {
        super.setRadius(radius);
    }



    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return getArea() * height;
    }


}
