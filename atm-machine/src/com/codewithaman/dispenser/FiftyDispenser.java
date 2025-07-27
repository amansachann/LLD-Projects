package com.codewithaman.dispenser;

public class FiftyDispenser extends NoteDispenser{
    private int availableNotes = 10;

    @Override
    public void dispense(int amount) {
        int num = Math.min(amount / 50, availableNotes);
        int remainder = amount - (num*50);
        availableNotes -= num;

        if (num>0) {
            System.out.println("Dispensed Rs50 x " + num);
        }
        if(remainder>0 && next != null) {
            next.dispense(remainder);
        } else if(remainder>0) {
            System.out.println("⚠\uFE0F Cannot dispense Rs" + remainder);
        }
    }

    @Override
    public boolean canDispense(int amount) {
        int needed = amount/50;
        return (needed <= availableNotes) || (next != null && next.canDispense(amount%50)
        );
    }
}
