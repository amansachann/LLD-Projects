package com.codewithaman.states;

import com.codewithaman.Coin;
import com.codewithaman.VendingMachine;

public class ItemSelectedState extends State {
    public ItemSelectedState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        machine.addBalance(coin.getValue());
        System.out.println("Coin added to machine: " + coin.getValue());
        int price = machine.getSelectedItem().getPrice();
        if(price <= machine.getBalance()) {
            System.out.println("Sufficient money received");
            machine.setCurrentState(new DispensingState(machine));
        }
    }

    @Override
    public void selectItem(String productCode) {
        System.out.println("Item already selected");
    }

    @Override
    public void dispense() {
        System.out.println("Please insert sufficient money");
    }

    @Override
    public void refund() {
        machine.reset();
        machine.setCurrentState(new IdleState(machine));
    }

}
