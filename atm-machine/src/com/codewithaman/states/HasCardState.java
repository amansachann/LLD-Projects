package com.codewithaman.states;

import com.codewithaman.ATM;
import com.codewithaman.BankService;
import com.codewithaman.Card;
import com.codewithaman.Session;

public class HasCardState implements AtmState {

    private final ATM atm;

    public HasCardState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("⚠\uFE0F Card is already inserted.");
    }

    @Override
    public void enterPin(String pin) {
        Session session = atm.getSession();
        Card card = session.getCurrentCard();

        boolean isValid = BankService.getInstance().validatePin(card, pin);
        if(isValid) {
            System.out.println("✅ PIN Verified");
            atm.setCurrentState(new AuthenticatedState(atm));
        } else {
            System.out.println("❌ Incorrect PIN, please try again");
        }
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("\uD83D\uDD10 Please enter your pin first.");
    }

    @Override
    public void deposit(int amount) {
        System.out.println("\uD83D\uDD10 Please enter your pin first.");
    }

    @Override
    public void checkBalance() {
        System.out.println("\uD83D\uDD10 Please enter your pin first.");

    }

    @Override
    public void ejectCard() {
        atm.clearSession();
        atm.setCurrentState(new IdleState(atm));
        System.out.println("\uD83D\uDCB3 Card ejected");
    }
}
