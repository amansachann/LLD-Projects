package com.codewithaman;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> productMap;
    private Map<String, Integer> stockMap;

    public Inventory() {
        this.productMap = new HashMap<>();
        this.stockMap = new HashMap<>();
    }

    // Add product
    public void addProduct(Product product, int quantity) {
        try{
            productMap.put(product.getCode(), product);
            stockMap.put(product.getCode(), quantity);
        } catch(Exception e){
            throw new RuntimeException("Cannot add product");
        }
    }

    // Check Availability
    public boolean isProductAvailable(String productCode) {
        return stockMap.containsKey(productCode);
    }


    // Reduce the stock
    public void reduceStock(Product product) {
        Integer currentQuantity = stockMap.get(product.getCode());
        stockMap.put(product.getCode(), stockMap.get(product.getCode()) - 1);
    }

    public Map<String, Product> getProductMap() {
        return productMap;
    }

    public Map<String, Integer> getStockMap() {
        return stockMap;
    }
}
