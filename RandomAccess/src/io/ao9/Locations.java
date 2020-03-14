package io.ao9;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>();
    private static Map<Integer, Index> indexes = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException {
        try(RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")){
//      No. of index | contents start point (locationStart) | index 1 (ID + content start point + content length) |
//            4                       4                               4*3
//      index 2 | index 3 | ... | content 1 | content 2 | ...
//        4*3      4*3
            int n = locations.size();
            int indexSize = Integer.BYTES * 3 * n;
            int locationStart = Integer.BYTES + Integer.BYTES + indexSize;

            rao.writeInt(n);
            rao.writeInt(locationStart);

            int indexStart = (int) rao.getFilePointer();
            rao.seek(locationStart);

            for(Location location : locations.values()){
                int startByte = (int) rao.getFilePointer();
                int locationID = location.getLocationID();
                String description = location.getDescription();

                rao.writeInt(locationID);
                rao.writeUTF(description);
                StringBuilder sb = new StringBuilder();
                for(Entry<String, Integer> exit : location.getExits().entrySet()){
                    if(!exit.getKey().equalsIgnoreCase("Q")) {
                        sb.append(exit.getKey());
                        sb.append(",");
                        sb.append(exit.getValue());
                        sb.append(",");
                    }
                }
                rao.writeUTF(sb.toString());

                indexes.put(locationID,new Index(startByte, (int) rao.getFilePointer()-startByte));
            }

            rao.seek(indexStart);
            for(Entry<Integer,Index> index : indexes.entrySet()){
                rao.writeInt(index.getKey());
                rao.writeInt(index.getValue().getStartByte());
                rao.writeInt(index.getValue().getLength());
            }

        }
    }

    static {
        try {
            System.out.println("Reading location indexes...");
            ra = new RandomAccessFile("locations_rand.dat","rwd");
            int n = ra.readInt();
            int locationStart = ra.readInt();

            while (ra.getFilePointer() < locationStart) {
                int locationID = ra.readInt();
                int startByte = ra.readInt();
                int length = ra.readInt();

                indexes.put(locationID,new Index(startByte, length));
            }
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }

//        locations.put(0, new Location(0, "in front of your computer", generateExits(-1, -1, -1, -1)));
//        locations.put(1, new Location(1, "on a road", generateExits(5, 2, 4, 3)));
//        locations.put(2, new Location(2, "on the top of a hill", generateExits(5, -1, 6, -1)));
//        locations.put(3, new Location(3, "inside a building", generateExits(-1, 1, -1, -1)));
//        locations.put(4, new Location(4, "at the bottom of a valley", generateExits(1, 2, -1, -1)));
//        locations.put(5, new Location(5, "in a forest", generateExits(-1, 2, 1, -1)));
//        locations.put(6, new Location(6, "at a dead end", generateExits(-1, -1, -1, -1)));
    }

    static Map<String, Integer> generateExits(int north, int west, int south, int east) {
        Map<String, Integer> exits = new LinkedHashMap<>();
        exits.put("N", north);
        exits.put("W", west);
        exits.put("S", south);
        exits.put("E", east);
        exits.put("Q", 0);
        return exits;
    }

    public Location getLocation(int locationID) throws IOException {
        System.out.println("Reading location " + locationID);
        Index index = indexes.get(locationID);
        int startByte = index.getStartByte();
        int length = index.getLength();

        ra.seek(startByte);
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitParts = exits.split(",");
        System.out.println("exitParts = " + Arrays.toString(exitParts));

        int north = -1, west = -1, south = -1, east = -1;
        for (int i = 0; i < exitParts.length; i++) {
            String direction = exitParts[i];
            i++;
            int destination = Integer.valueOf(exitParts[i]);
            switch (direction) {
                case "N":
                    north = destination;
                    break;
                case "W":
                    west = destination;
                    break;
                case "S":
                    south = destination;
                    break;
                case "E":
                    east = destination;
                    break;
            }
        }
        return new Location(locationID, description, generateExits(north, west, south, east));
    }

    public void close() throws IOException {
        ra.close();
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
