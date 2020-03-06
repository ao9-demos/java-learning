package com.company;

import java.util.*;

public class Main {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    private static Set<HeavenlyBody> moons = new HashSet<>();

    public static void main(String[] args) {

        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Pluto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);
        tempMoon = new Moon("Pluto", 36.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        for(HeavenlyBody planet : planets){
            moons.addAll(planet.getSatellites());
        }

        printPlanets();
        printMoons();

        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyType.PLANET)));
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyType.MOON)));

    for(HeavenlyBody body : solarSystem.values()){
        System.out.println(body);
    }
    }

    private static void printPlanets() {
        System.out.println("==================");
        System.out.println("All planets with their moons");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet);
            for (HeavenlyBody moon : planet.getSatellites()) {
                System.out.println("\t\t-" + moon);
            }
        }
    }

    private static void printMoons(){
        System.out.println("==================");
        System.out.println("All moons");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon);
        }
    }

    private static void printOnePlanet(String planetName) {
        System.out.println("==================");
        HeavenlyBody planet = solarSystem.get(planetName);
        System.out.println("The planet with its moons");
        System.out.println("\t" + planet);
        for (HeavenlyBody moon : planet.getSatellites()) {
            System.out.println("\t\t-" + moon);
        }
    }
}
