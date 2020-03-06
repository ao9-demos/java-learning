package com.company;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private String name;
    private double orbitalPeriod;
    private Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public boolean addMoon(HeavenlyBody moon){
        return satellites.add(moon);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        System.out.println("getClass() = " + getClass());
        System.out.println("o.getClass() = " + o.getClass());
        if(o == null || getClass() != o.getClass()){
            return false;
        }

        HeavenlyBody that = (HeavenlyBody) o;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        System.out.println("name.hashCode() = " + name.hashCode());
        return (name != null) ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return satellites;
    }
}
