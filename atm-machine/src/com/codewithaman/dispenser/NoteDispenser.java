package com.codewithaman.dispenser;

public abstract class NoteDispenser {

    protected NoteDispenser next;

    public void setNext(NoteDispenser next) {
        this.next = next;
    }

    public abstract boolean canDispense(int amount);

    public abstract void dispense(int amount);
}
