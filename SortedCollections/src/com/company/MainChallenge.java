package com.company;

import java.util.Map;

public class MainChallenge {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Cup", 10.5, 100);
        stockList.addStock(temp);

        temp = new StockItem("Egg", 1.5, 50);
        stockList.addStock(temp);

        temp = new StockItem("Apple", 2.5, 100);
        stockList.addStock(temp);

        temp = new StockItem("Egg", 2.5, 50);
        stockList.addStock(temp);


        temp = new StockItem("Flower", 12.5, 100);
        stockList.addStock(temp);

        temp = new StockItem("Bread", 7.5, 100);
        stockList.addStock(temp);

        temp = new StockItem("Duck", 17.5, 100);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket basket1 = new Basket("bb1");
        Basket basket2 = new Basket("bb2");
        System.out.println(reserve(basket1,"Duck", 30));
        System.out.println(reserve(basket1,"Duck", 30));
        System.out.println(reserve(basket2,"Duck", 30));
        System.out.println(reserve(basket2,"Duck", 30));
        System.out.println(unreserve(basket1,"Duck", 10));
        System.out.println(unreserve(basket1,"Duck", 200));
        System.out.println(unreserve(basket2,"Duck", 10));
        System.out.println(reserve(basket2,"Duck", 30));
        System.out.println(reserve(basket1,"Apple", 30));
        System.out.println(reserve(basket2,"Bread", 20));
        System.out.println(reserve(basket1,"Cup", 10));
        System.out.println(reserve(basket2,"Egg", 70));


        System.out.println(basket1);
        System.out.println(basket2);

        try {
            checkout(basket1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(stockList);

        try {
            checkout(basket2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(stockList);
        System.out.println(basket1);
        System.out.println(basket2);


    }

    private static int reserve(Basket basket, String itemName, int quantity) {
        return quantity > 0 ? adjustReserve(basket,itemName,quantity) : 0;
    }

    private static int unreserve(Basket basket, String itemName, int quantity) {
        return quantity > 0 ? adjustReserve(basket,itemName,-quantity) : 0;
    }

    private static int adjustReserve(Basket basket, String itemName, int quantity) {
        if (basket != null) {
            StockItem inStock = stockList.get(itemName);
            if (basket.adjustItem(inStock, quantity) != 0) {
                return quantity;
            }
        }
        return 0;
    }

    private static void checkout(Basket basket) throws InterruptedException {
        if (basket != null) {
            for(Map.Entry<StockItem, Integer> item : basket.getList().entrySet()){
                item.getKey().adjustReserve(-item.getValue());
                stockList.sellStock(item.getKey().getName(),item.getValue());
                System.out.println("Selling item " + item.getKey().getName() + "...");
                Thread.sleep(500);
            }
            basket.clearBasket();
        }
    }
}
