package com.codewithaman;

import com.codewithaman.states.IdleState;
import com.codewithaman.states.State;

public class VendingMachine {
    private Inventory inventory;
    private State currentState;
    private String selectedItemCode;
    private int balance;

    private VendingMachine() {
        this.inventory = new Inventory();
        this.currentState = new IdleState(this);
        this.selectedItemCode = null;
        this.balance = 0;
    }


    public static class SingletonHelper {
        private static final VendingMachine INSTANCE = new VendingMachine();
    }

    public static VendingMachine getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Product getSelectedItem() {
        return inventory.getProductMap().get(selectedItemCode);
    }

    public void setSelectedItemCode(String selectedItemCode) {
        this.selectedItemCode = selectedItemCode;
    }

    public void setSelectedItem(String selectedItemCode) {
        this.selectedItemCode = selectedItemCode;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int val) {
        this.balance += val;
    }

    public void reset() {
        this.balance = 0;
        this.selectedItemCode = null;
    }

    public void dispenseItem() {
        Product product = inventory.getProductMap().get(selectedItemCode);
        if(balance >= product.getPrice()) {
            inventory.reduceStock(product);
            balance -= product.getPrice();
            System.out.println("Dispensed: " + product.getName());
            if(balance > 0) {
                refundBalance();
            }
        }
        this.reset();
        this.setCurrentState(new IdleState(this));
    }

    public void refundBalance() {
        System.out.println("Refunding balance: " +  balance );
        this.balance = 0;
    }

    public Product addProduct(String code, String name, int price, int quantity) {
        Product product = new Product(code, name, price);
        inventory.addProduct(product, quantity);
        return product;
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void dispense() {
        currentState.dispense();
    }

    public void selectProduct(String code) {
        currentState.selectItem(code);
    }
}
