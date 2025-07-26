package com.codewithaman;

public class UpiPayment implements Payment{
    @Override
    public boolean pay(int amount) {
        System.out.println("Paid Rs" + amount + " via UPI.");
        return true;
    }

    @Override
    public void refund(int amount) {
        System.out.println("Refunded " + amount + " via UPI.");
    }
}
