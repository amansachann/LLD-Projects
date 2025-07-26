package com.codewithaman.states;

import com.codewithaman.CoffeeMachine;
import com.codewithaman.CoffeeType;
import com.codewithaman.Payment;

public interface MachineState {
    void handle(CoffeeMachine machine, CoffeeType type, Payment paymentMethod);
}
