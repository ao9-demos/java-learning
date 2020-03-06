package com.company;

public class TV {
    private String brand;
    private int volume;
    private Dimensions dimensions;

    public TV(String brand, int volume, Dimensions dimensions) {
        this.brand = brand;
        this.volume = volume;
        this.dimensions = dimensions;
    }

    public void changeVolume(int rate) {
        volume += rate;
        if(volume < 0){
            volume = 0;
        }
        System.out.println("Volume is set to " + volume);
    }

    public String getBrand() {
        return brand;
    }


    public int getVolume() {
        return volume;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
}
