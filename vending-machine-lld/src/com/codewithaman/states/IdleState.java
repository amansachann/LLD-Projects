package com.codewithaman.states;

import com.codewithaman.Coin;
import com.codewithaman.VendingMachine;

public class IdleState extends State{
    public IdleState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select an item first");
    }

    @Override
    public void selectItem(String productCode) {
        if(!machine.getInventory().isProductAvailable(productCode)) {
            System.out.println("Product not available");
            return;
        }
        machine.setSelectedItemCode(productCode);
        machine.setCurrentState(new ItemSelectedState(machine));
        System.out.println("Item "+productCode+" selected");
    }

    @Override
    public void dispense() {
        System.out.println("Please select an item first");
    }

    @Override
    public void refund() {
        System.out.println("Please select an item first");
    }
}
