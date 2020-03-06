package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Player p1 = new Player("elf", 3, 100, "blink", "arrow");
        Player p2 = new Player();
        Monster m1 = new Monster("Rocky", 10, 600, "20", "gold");
        Monster m2 = new Monster();
        List<String> savedData = new ArrayList<>();

        System.out.println("p1 " + p1);
        savedData = save(p1);
        Load(p2, savedData);
        savedData = save(m1);
        Load(m2, savedData);

        System.out.println("p2 " + p2);
        System.out.println("m2 " + m2);
    }

    private static List<String> save(ISaveable objectToSave) {
        return objectToSave.write();
    }

    private static void Load(ISaveable objectToLoad, List<String> savedData) {
        objectToLoad.read(savedData);
    }
}
