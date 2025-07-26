package com.codewithaman;

public interface Payment {
    boolean pay(int amount);
    void refund(int amount);
}
