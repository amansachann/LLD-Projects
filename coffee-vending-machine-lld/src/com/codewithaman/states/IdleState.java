package com.codewithaman.states;

import com.codewithaman.CoffeeMachine;
import com.codewithaman.CoffeeType;
import com.codewithaman.Payment;

public class IdleState implements MachineState{
    @Override
    public void handle(CoffeeMachine machine, CoffeeType type, Payment paymentMethod) {
        if (!machine.getStore().hasEnough(type.getRecipe())) {
            System.out.println("❌ Insufficient ingredients for " + type);
            return;
        }

        System.out.println("✅ Ingredients available. Moving to PREPARING state.");
        machine.setCurrentState(new PreparingState());
        machine.processOrder(type, paymentMethod);
    }

}
