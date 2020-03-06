package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Location> locationMap = new HashMap<>();

        locationMap.put(0, new Location(0, "in front of your computer",null));
        locationMap.put(1, new Location(1, "on a road", generateExits(5,2,4,3)));
        locationMap.put(2, new Location(2, "on the top of a hill",generateExits(5,-1,6,-1)));
        locationMap.put(3, new Location(3, "inside a building",generateExits(-1,1,-1,-1)));
        locationMap.put(4, new Location(4, "at the bottom of a valley",generateExits(1,2,-1,-1)));
        locationMap.put(5, new Location(5, "in a forest",generateExits(-1,2,1,-1)));
        locationMap.put(6, new Location(6, "at a dead end",null));

        int loc = 1;
        while (true) {
            Location currentLoc = locationMap.get(loc);
            System.out.println("You're " + currentLoc.getDescription());
            if (loc == 0) {
                break;
            }
            System.out.println("Available exits are ");
            for(String exit : currentLoc.getExits().keySet()){
                System.out.print(exit + " ");
            }

            String direction = null;
            Map<String, String> vocabulary = new HashMap<>();
            vocabulary.put("QUIT", "Q");
            vocabulary.put("Q", "Q");
            vocabulary.put("NORTH", "N");
            vocabulary.put("N", "N");
            vocabulary.put("WEST", "W");
            vocabulary.put("W", "W");
            vocabulary.put("SOUTH", "S");
            vocabulary.put("S", "S");
            vocabulary.put("EAST", "E");
            vocabulary.put("E", "E");

            String[] inputs = scanner.nextLine().toUpperCase().split(" ");
            int directionCount = 0;
            for(String word : inputs){
                if(vocabulary.containsKey(word)){
                    direction = vocabulary.get(word);
                    directionCount++;
                }
            }

            if((direction == null) || (!currentLoc.getExits().containsKey(direction))){
                System.out.println("xxxxxxxxx No such direction xxxxxxxxxxx");
            } else if(directionCount>1){
                System.out.println("xxxxxxxxx Too many directions xxxxxxxxxxx");
            } else {
                loc = currentLoc.getExits().get(direction);
                System.out.println("............travelling to " + direction + " ...............");
            }
        }
    }
    
    private static Map<String, Integer> generateExits(int north,int west,int south, int east){
        Map<String, Integer> exits = new HashMap<>();
        if (north >= 0) {
            exits.put("N",north);
        }
        if (west >= 0) {
            exits.put("W",west);
        }
        if (south >= 0) {
            exits.put("S",south);
        }
        if (east >= 0) {
            exits.put("E",east);
        }
        return exits;
    }
}
