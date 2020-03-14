package io.ao9;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))){
            for (Location location : locations.values()){
                locFile.writeObject(location);
            }
        }
//        Path locPath = FileSystems.getDefault().getPath("locations.txt");
//        Path extPath = FileSystems.getDefault().getPath("exits.txt");
//        try (BufferedWriter locFile = Files.newBufferedWriter(locPath);
//             BufferedWriter extFile = Files.newBufferedWriter(extPath)) {
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//
//                extFile.write(String.valueOf(location.getLocationID() + ","));
//                for (Entry<String, Integer> exit : location.getExits().entrySet()) {
//                    extFile.write(exit.getKey() + "," + exit.getValue() + ",");
//                }
//                extFile.write("\n");
//            }
//        }
    }

    static {
        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))){
            boolean eof = false;
            while(!eof) {
                try {
                    Location location = (Location) locFile.readObject();
                    locations.put(location.getLocationID(),location);
                } catch (EOFException e){
                    eof = true;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//        Path locPath = FileSystems.getDefault().getPath("locations.txt");
//        Path extPath = FileSystems.getDefault().getPath("exits.txt");
//        try (BufferedReader locFile = Files.newBufferedReader(locPath);
//             BufferedReader extFile = Files.newBufferedReader(extPath)) {
//            String input;
//            while ((input = locFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.valueOf(data[0]);
//                String description = data[1];
//                System.out.println(loc + "-" + description);
//                locations.put(loc, new Location(loc, description, null));
//            }
//
//            while ((input = extFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.valueOf(data[0]);
//
//                int north = -1, west = -1, south = -1, east = -1;
//                for (int i = 1; i <= 10; i++) {
//                    String direction = data[i];
//                    i++;
//                    int destination = Integer.valueOf(data[i]);
//                    switch (direction) {
//                        case "N":
//                            north = destination;
//                            break;
//                        case "W":
//                            west = destination;
//                            break;
//                        case "S":
//                            south = destination;
//                            break;
//                        case "E":
//                            east = destination;
//                            break;
//                    }
//                }
//                locations.get(loc).setExits(generateExits(north, west, south, east));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        locations.put(0, new Location(0, "in front of your computer", generateExits(-1, -1, -1, -1)));
//        locations.put(1, new Location(1, "on a road", generateExits(5, 2, 4, 3)));
//        locations.put(2, new Location(2, "on the top of a hill", generateExits(5, -1, 6, -1)));
//        locations.put(3, new Location(3, "inside a building", generateExits(-1, 1, -1, -1)));
//        locations.put(4, new Location(4, "at the bottom of a valley", generateExits(1, 2, -1, -1)));
//        locations.put(5, new Location(5, "in a forest", generateExits(-1, 2, 1, -1)));
//        locations.put(6, new Location(6, "at a dead end", generateExits(-1, -1, -1, -1)));
    }

    static Map<String, Integer> generateExits(int north, int west, int south, int east) {
        Map<String, Integer> exits = new HashMap<>();
        exits.put("N", north);
        exits.put("W", west);
        exits.put("S", south);
        exits.put("E", east);
        exits.put("Q", 0);
        return exits;
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsKey(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
