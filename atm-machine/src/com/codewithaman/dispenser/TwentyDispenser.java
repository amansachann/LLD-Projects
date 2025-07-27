package com.codewithaman.dispenser;

public class TwentyDispenser extends NoteDispenser{
    private int availableNotes = 10;

    @Override
    public void dispense(int amount) {
        int num = Math.min(amount / 20, availableNotes);
        int remainder = amount - (num*20);
        availableNotes -= num;

        if (num>0) {
            System.out.println("Dispensed Rs100 x " + num);
        }
        if(remainder>0 && next != null) {
            next.dispense(remainder);
        } else if(remainder>0) {
            System.out.println("⚠\uFE0F Cannot dispense Rs" + remainder);
        }
    }

    @Override
    public boolean canDispense(int amount) {
        int needed = amount/20;
        return (needed <= availableNotes) || (next != null && next.canDispense(amount%20)
        );
    }
}
