package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();
    private static Set<HeavenlyBody> moons = new HashSet<>();

    public static void main(String[] args) {

        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        temp.addMoon(tempMoon);

        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars

        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter

        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 353);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

//        for(HeavenlyBody planet : planets){
//            moons.addAll(planet.getSatellites());
//        }

        printPlanets();
//        printMoons();
//        printOnePlanet("Jupiter");
//        printOnePlanet("Pluto");

    }

    private static void printPlanets() {
        System.out.println("==================");
        System.out.println("All planets with their moons");
        for (HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName() + ": " + planet.getOrbitalPeriod());
            for (HeavenlyBody moon : planet.getSatellites()) {
                System.out.println("\t\t-" + moon.getName() + ": " + planet.getOrbitalPeriod());
            }
        }
    }

    private static void printMoons(){
        System.out.println("==================");
        System.out.println("All moons");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }
    }

    private static void printOnePlanet(String planetName) {
        System.out.println("==================");
        HeavenlyBody planet = solarSystem.get(planetName);
        System.out.println("The planet with its moons");
        System.out.println("\t" + planet.getName());
        for (HeavenlyBody moon : planet.getSatellites()) {
            System.out.println("\t\t-" + moon.getName());
        }
    }
}
