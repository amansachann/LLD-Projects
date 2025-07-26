package com.codewithaman;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        CoffeeType type = CoffeeType.ESPRESSO;
        Payment paymentMethod = new UpiPayment();
        machine.processOrder(type, paymentMethod);
    }
}
