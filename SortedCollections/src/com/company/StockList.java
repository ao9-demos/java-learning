package com.company;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class StockList {
    private Map<String, StockItem> list;

    public StockList() {
        this.list = new TreeMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String itemName, int quantity) {
        StockItem inStock = list.getOrDefault(itemName, null);
        if ((inStock != null) && (quantity > 0)) {
            if (inStock.quantityInStock() > quantity) {
                inStock.adjustStock(-quantity);
            } else if(inStock.quantityInStock() == quantity) {
                list.remove(itemName);
            }
            return quantity;
        }
        return 0;
    }

    public StockItem get(String itemName){
        return list.get(itemName);
    }

    public Map<String, StockItem> getList() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nThere're " + list.size() + (list.size() <= 1 ? " item" : " items") + " in stock";
        for(StockItem item : list.values()){
            s += ("\n" + item + ", quantity: " + item.quantityInStock() + ", reserved: " + item.quantityReserved());
        }
        return s;
    }
}
