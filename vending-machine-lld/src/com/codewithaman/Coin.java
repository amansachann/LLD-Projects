package com.codewithaman;

public enum Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(15)
    ;

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
