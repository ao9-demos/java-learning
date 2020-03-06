package com.company;

public class Floor {
    private String color;
    private boolean isHeatingOn;
    private TheArea area;

    public Floor(String color, boolean isHeatingOn, TheArea area) {
        this.color = color;
        this.isHeatingOn = isHeatingOn;
        this.area = area;
    }

    public void turnOnHeating(){
        if(isHeatingOn){
            System.out.println("Heating is already on");
        } else {
            isHeatingOn = true;
            System.out.println("Heating turned on");
        }
    }

    public String getColor() {
        return color;
    }

    public boolean isHeatingOn() {
        return isHeatingOn;
    }

    public TheArea getArea() {
        return area;
    }
}
