package com.company;

public class Main {
    private static final double PI = Math.PI;

    public static void main(String[] args) {
        System.out.println(area(123.2));
        System.out.println(area(-123));
        System.out.println(area(12,213123.3));
    }

    public static double area(double radius){
        double area = -1.0;
        if (radius >= 0) {
            area = PI * radius * radius;
        }
        return area;
    }

    public static double area(double x, double y) {
        double area = -1.0;
        if (x >= 0 && y >= 0) {
            area = x * y;
        }
        return area;
    }
}
