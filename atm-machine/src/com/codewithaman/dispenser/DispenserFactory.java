package com.codewithaman.dispenser;

public class DispenserFactory {
    public static NoteDispenser createChain() {
        NoteDispenser hundred = new HundredDispenser();
        NoteDispenser fifty = new FiftyDispenser();
        NoteDispenser twenty = new TwentyDispenser();

        hundred.setNext(fifty);
        fifty.setNext(twenty);

        return hundred;
    }
}
