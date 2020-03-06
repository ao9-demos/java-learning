package com.company;

import java.util.ArrayList;
import java.util.List;

public class Gearbox {
    private List<Gear> gearList;
    private int maxGear;
    private int countGear = 0;

    public Gearbox(int maxGear) {
        this.gearList = new ArrayList<Gear>();
        this.maxGear = maxGear;
        Gear neutral = new Gear(0, 0.0);
        this.gearList.add(neutral);
        this.countGear += 1;
    }

    public void addGear(int gearNumber, double ratio) {
        if (gearNumber > maxGear) {
            System.out.println("Extended max gear number");
        } else if (gearNumber < 0) {
            System.out.println("Invalid gear number");
        } else {
            if (findGear(gearNumber) != null) {
                System.out.println("This gear already exists");
            } else {
                Gear gear = new Gear(gearNumber, ratio);
                this.gearList.add(gear);
                countGear += 1;
                System.out.println("Gear added");
            }
        }
    }

    private Gear findGear(int gearNumber){
        for(Gear checkGear : this.gearList){
            if (checkGear.gearNumber == gearNumber) {
                return checkGear;
            }
        }
        return null;
    }

    public void switchGear(int gearNumber, int revs) {
        if (gearNumber > maxGear) {
            System.out.println("Extended max gear number");
        } else if (gearNumber < 0) {
            System.out.println("Invalid gear number");
        } else {
            if (findGear(gearNumber) == null) {
                System.out.println("No such gear");
            } else {
                double speed = findGear(gearNumber).driveSpeed(revs);
                System.out.println("Switched to gear " + gearNumber + " speed is " + speed);
            }
        }
    }

    private class Gear {
        private int gearNumber;
        private double ratio;

        private Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        private double driveSpeed(int revs) {
            return revs * this.ratio;
        }
    }


}
