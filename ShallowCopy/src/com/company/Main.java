package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, ValueContainer> valueMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            valueMap.put(i, new ValueContainer(i));
        }
        Map<Integer, ValueContainer> valueMapCopy = new HashMap<>(valueMap);
        valueMapCopy.get(3).setValue(333);
        valueMapCopy.remove(4);
        printMap(valueMap);
        printMap(valueMapCopy);

        List<ValueContainer> valueList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            valueList.add(new ValueContainer(i));
        }
        List<ValueContainer> valueListCopy = new ArrayList<>(valueList);
        valueListCopy.get(3).setValue(333);
        valueListCopy.remove(4);
        printList(valueList);
        printList(valueListCopy);




    }

    private static void printMap(Map<Integer, ValueContainer> map) {
        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key).getValue() + " | " + map.get(key));
        }
        System.out.println("===========");
    }

    private static void printList(List<ValueContainer> list) {
        for (ValueContainer valueContainer : list) {
            System.out.println(valueContainer.getValue() + " | " + valueContainer);
        }
        System.out.println("===========");
    }
}
