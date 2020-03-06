package com.company;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("Cup", 10.5, 300);
        stockList.addStock(temp);

        temp = new StockItem("Egg", 1.5, 400);
        stockList.addStock(temp);

        temp = new StockItem("Apple", 2.5, 100);
        stockList.addStock(temp);

        temp = new StockItem("Egg", 2.5, 100);
        stockList.addStock(temp);


        temp = new StockItem("Flower", 12.5, 600);
        stockList.addStock(temp);

        temp = new StockItem("Bread", 7.5, 200);
        stockList.addStock(temp);

        temp = new StockItem("Duck", 17.5, 400);
        stockList.addStock(temp);

        temp = new StockItem("Test", 17.5, -100);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket basket1 = new Basket("b111");
        System.out.println(sellItem(basket1,"Duck",100));
        System.out.println(sellItem(basket1,"Beef",100));
        System.out.println(sellItem(basket1,"Egg",-100));
        System.out.println(sellItem(basket1,"Egg",900));
        System.out.println(stockList);
        System.out.println(basket1);

        System.out.println(sellItem(basket1,"Egg",100));
        System.out.println(sellItem(basket1,"Bread",200));
        System.out.println(basket1);

        System.out.println(stockList);


    }

    private static int sellItem(Basket basket, String itemName, int quantity) {
        if (basket != null && quantity > 0) {
            StockItem inStock = stockList.get(itemName);
            if (stockList.sellStock(itemName, quantity) > 0) {
                basket.adjustItem(inStock, quantity);
                return quantity;
            }
        }
        return 0;
    }
}
