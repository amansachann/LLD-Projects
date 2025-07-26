package com.codewithaman.states;

import com.codewithaman.CoffeeMachine;
import com.codewithaman.CoffeeType;
import com.codewithaman.Payment;

public class PreparingState implements MachineState {
    public void handle(CoffeeMachine machine, CoffeeType type, Payment payment) {
        boolean paid = payment.pay(type.getPrice());

        if (!paid) {
            System.out.println("❌ Payment failed.");
            payment.refund(type.getPrice());
            machine.setCurrentState(new IdleState());
            return;
        }

        machine.getStore().consume(type.getRecipe());
        System.out.println("🛠️ Preparing your " + type + "...");
        machine.setCurrentState(new DispensingState());
        machine.processOrder(type, payment);
    }
}