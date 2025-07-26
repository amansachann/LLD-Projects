package com.codewithaman;

public class Recipe {
    private int water, milk, coffeeBeans, sugar;

    public Recipe(int water, int milk, int coffeeBeans, int sugar) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.sugar = sugar;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getSugar() {
        return sugar;
    }
}
