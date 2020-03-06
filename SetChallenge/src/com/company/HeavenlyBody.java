package com.company;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class HeavenlyBody {
    private final double orbitalPeriod;
    private final Key key;
    private Set<HeavenlyBody> satellites;

    enum BodyType {
        STAR,
        PLANET,
        MOON
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyType type) {
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.key = new Key(name, type);
    }

    public boolean addSatellite(HeavenlyBody moon){
        return satellites.add(moon);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        HeavenlyBody that = (HeavenlyBody) o;
        return key.equals(that.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    public static Key makeKey(String name, BodyType type){
        return new Key(name,type);
    }

    public String getName() {
        return key.name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return satellites;
    }

    public BodyType getType() {
        return key.type;
    }

    public Key getKey() {
        return key;
    }

    @Override
    public String toString() {
        return getName() + " " + getType() + " " + getOrbitalPeriod();
    }

    public static class Key {
        private final String name;
        private final BodyType type;

        private Key(String name, BodyType type) {
            this.name = name;
            this.type = type;
        }

        @Override
        public boolean equals(Object o) {
            Key that = (Key) o;
            if (type != that.type) return false;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (type != null ? type.hashCode() : 0);
            return result;
        }
    }
}
