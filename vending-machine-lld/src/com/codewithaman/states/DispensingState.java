package com.codewithaman.states;

import com.codewithaman.Coin;
import com.codewithaman.VendingMachine;

public class DispensingState extends State {
    public DispensingState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Already received the sufficient amount");
    }

    @Override
    public void selectItem(String productCode) {
        System.out.println("Item already selected");
    }

    @Override
    public void dispense() {
        machine.dispenseItem();
    }

    @Override
    public void refund() {
        machine.refundBalance();
        machine.reset();
        machine.setCurrentState(new IdleState(machine));
    }
}
