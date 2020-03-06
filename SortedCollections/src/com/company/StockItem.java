package com.company;

import java.util.Objects;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;
    private int quantityReserve;

    public StockItem(String name, double price) {
        this(name, price, 0);
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock > 0 ? quantityStock : 0;
        this.quantityReserve = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public int quantityReserved(){
        return quantityReserve;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    public int adjustStock(int quantity) {
        int newQuantity = quantityStock + quantity;
        if (newQuantity >= 0) {
            quantityStock = newQuantity;
            return quantity;
        }
        return 0;
    }

    public int adjustReserve(int quantity){
        int newReserve = quantityReserve + quantity;
        if(newReserve >= 0 && newReserve <= quantityStock){
            quantityReserve = newReserve;
            return quantity;
        }
        return 0;
    }

    @Override
    public int compareTo(StockItem o) {
        if (o == this) {
            return 0;
        }
        if (o != null) {
            return name != null ? (o.name != null ? name.compareTo(o.name) : 1) : (o.name != null ? -1 : 0);
        }
        throw new NullPointerException();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        StockItem that = (StockItem) obj;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return (name != null) ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name + ": $" + String.format("%.2f", price);
    }
}
