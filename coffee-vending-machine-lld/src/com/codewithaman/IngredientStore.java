package com.codewithaman;

import java.util.HashMap;
import java.util.Map;

public class IngredientStore {
    private final Map<String, Integer> inventory;

    public IngredientStore() {
        this.inventory = new HashMap<>();
        inventory.put("water", 1000);
        inventory.put("milk", 1000);
        inventory.put("coffeeBeans", 500);
        inventory.put("sugar", 300);
    }

    public boolean hasEnough(Recipe recipe) {
        return inventory.get("water") >= recipe.getWater() &&
                inventory.get("milk") >= recipe.getMilk() &&
                inventory.get("coffeeBeans") >= recipe.getCoffeeBeans() &&
                inventory.get("sugar") >= recipe.getSugar();
    }

    public void consume(Recipe recipe) {
        inventory.put("water", inventory.get("water")-recipe.getWater());
        inventory.put("milk", inventory.get("milk")-recipe.getMilk());
        inventory.put("coffeeBeans", inventory.get("coffeeBeans") - recipe.getMilk());
        inventory.put("sugar", inventory.get("sugar")-recipe.getSugar());
    }

    public void refill(String ingredient, Integer qty) {
        inventory.put(ingredient, inventory.getOrDefault(ingredient, 0) + qty);
    }

    public void checkInventory() {
        System.out.println("Current Inventory Status:");
        inventory.forEach((ingredient, qty) -> System.out.println(" - " + ingredient + ": " + qty));
    }

}
