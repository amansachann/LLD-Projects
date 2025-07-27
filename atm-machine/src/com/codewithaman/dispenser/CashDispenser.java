package com.codewithaman.dispenser;

public class CashDispenser {

    private final NoteDispenser chainHead;

    public CashDispenser(NoteDispenser chainHead) {
        this.chainHead = chainHead;
    }

    public boolean canDispene(int amount) {
        return chainHead.canDispense(amount);
    }

    public void dispense(int amount) {
        chainHead.dispense(amount);
    }
}
