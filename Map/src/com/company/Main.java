package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        dictionary.put("1", "1abcd");
        dictionary.put("2", "2adfg");
        dictionary.put("3", "3abcd");
        System.out.println(dictionary.put("4", "4adfg"));
        System.out.println(dictionary.put("1", "111abcd"));
        System.out.println("=======================================");
        System.out.println(dictionary.putIfAbsent("4", "444adfg"));
        System.out.println(dictionary.get("2"));
        System.out.println("=======================================");
        printMap();
        System.out.println("=======================================");
        System.out.println(dictionary.remove("3"));
        System.out.println(dictionary.remove("4", "asdf"));
        printMap();
        System.out.println("=======================================");
        System.out.println(dictionary.replace("4","41412dd"));
        System.out.println(dictionary.replace("4","sdfsdf","42411"));

    }

    private static void printMap() {
        for (String key : dictionary.keySet()) {
            System.out.println(dictionary.get(key));
        }
    }
}
