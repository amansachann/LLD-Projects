package com.codewithaman;

import com.codewithaman.states.IdleState;
import com.codewithaman.states.MachineState;

public class CoffeeMachine {
    private final IngredientStore store;
    private MachineState currentState;

    enum State {IDLE, PREPARING, DISPENSING};

    public CoffeeMachine() {
        this.store = new IngredientStore();
        this.currentState = new IdleState();
    }

    public IngredientStore getStore() {
        return store;
    }

    public void setCurrentState(MachineState currentState) {
        this.currentState = currentState;
    }

    public synchronized void processOrder(CoffeeType type, Payment paymentMethod) {
       currentState.handle(this, type, paymentMethod);
    }

    public void refill(String ingredient, Integer qty) {
        store.refill(ingredient, qty);
    }

    public void displayInventory() {
        store.checkInventory();
    }
}
