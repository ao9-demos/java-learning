package com.company;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        if (length >= 0) {
            this.length = length;
        } else {
            this.length =0;
        }
        if (width >= 0) {
            this.width = width;
        } else {
            this.width = 0;
        }
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return width * length;
    }
}
