package com.codewithaman.states;

import com.codewithaman.CoffeeMachine;
import com.codewithaman.CoffeeType;
import com.codewithaman.Payment;

public class DispensingState implements MachineState {
    @Override
    public void handle(CoffeeMachine machine, CoffeeType type, Payment payment) {
        System.out.println("☕ Dispensing your " + type + "...");
        System.out.println("✅ Enjoy your coffee!");
        machine.setCurrentState(new IdleState());
    }
}
