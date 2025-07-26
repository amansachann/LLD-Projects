package com.codewithaman;

public enum CoffeeType {
    ESPRESSO("Espresso", new Recipe(50, 0, 18, 0), 50),
    LATTE("Latte", new Recipe(200, 150, 24, 10), 70),
    CAPPUCCINO("Cappuccino", new Recipe(250, 100, 20, 10), 80);

    private final String name;
    private final Recipe recipe;
    private final int price;

    CoffeeType(String name, Recipe recipe, int price) {
        this.name = name;
        this.recipe = recipe;
        this.price = price;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name;
    }
}
