package com.company;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String,Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null) {
            this.exits = new HashMap<>(exits);
        } else {
            this.exits = new HashMap<>();
        }
        this.exits.put("Q", 0);
    }

    private boolean addExit(String direction, Integer locationID){
        if (exits.containsKey(direction)) {
            System.out.println("Already has this exit, can't add");
            return false;
        } else {
            exits.put(direction, locationID);
            System.out.println("Exit " + direction + " added");
            return true;
        }
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return  new HashMap<>(exits);
    }
}

