package com.company;

public class Planet extends HeavenlyBody {
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if(moon.getType() == BodyType.MOON) {
            return super.addSatellite(moon);
        } else {
            System.out.println("Can't add a " + moon.getType() + " as a satellite");
            return false;
        }
    }
}
