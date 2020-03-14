package io.ao9;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    private static Locations locations = new Locations();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int locationID = 1;
        while (true) {
            Location currentLoc = locations.getLocation(locationID);
            System.out.println("You're " + currentLoc.getDescription());
            if (locationID == 0) {
                break;
            }
            System.out.println("Available exits are ");
            for(Map.Entry<String,Integer> exit : currentLoc.getExits().entrySet()){
                if (exit.getValue() >= 0) {
                    System.out.print(exit.getKey() + " ");
                }
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

            if((direction == null) || (currentLoc.getExits().get(direction) < 0)){
                System.out.println("xxxxxxxxx No such direction xxxxxxxxxxx");
            } else if(directionCount>1){
                System.out.println("xxxxxxxxx Too many directions xxxxxxxxxxx");
            } else {
                locationID = currentLoc.getExits().get(direction);
                System.out.println("............travelling to " + direction + " ...............");
            }
        }
    }
}
