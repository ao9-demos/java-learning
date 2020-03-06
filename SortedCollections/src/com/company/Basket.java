package com.company;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int adjustItem(StockItem item, int quantity) {
        if (item != null) {
            int newQuantity = list.getOrDefault(item, 0) + quantity;
            if (newQuantity >= 0 && item.adjustReserve(quantity) != 0) {
                if (newQuantity != 0) {
                    list.put(item, newQuantity);
                } else {
                    list.remove(item);
                }
                return quantity;
            }
        }
        return 0;
    }

    public void clearBasket() {
        list.clear();
    }

    public String getName() {
        return name;
    }

    public Map<StockItem, Integer> getList() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nThere're " + list.size() + (list.size() <= 1 ? " item" : " items") + " in basket " + name;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s += ("\n" + item.getKey() + ", quantity: " + item.getValue());
        }
        return s;
    }
}
