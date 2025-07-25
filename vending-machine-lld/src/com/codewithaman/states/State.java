package com.codewithaman.states;

import com.codewithaman.Coin;
import com.codewithaman.VendingMachine;

public abstract class State {
    VendingMachine machine;

    public State(VendingMachine machine) {
        this.machine = machine;
    }

    public abstract void insertCoin(Coin coin);
    public abstract void selectItem(String productCode);
    public abstract void dispense();
    public abstract void refund();
}
