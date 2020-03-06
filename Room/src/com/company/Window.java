package com.company;

public class Window {
    private TheArea area;
    private boolean isOpen;

    public Window(TheArea area, boolean isOpen) {
        this.area = area;
        this.isOpen = isOpen;
    }

    public void openWindow(){
        if(isOpen){
            System.out.println("Window is already opened");
        } else {
            System.out.println("Opening window");
            isOpen = true;
        }
    }

    public TheArea getArea() {
        return area;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
