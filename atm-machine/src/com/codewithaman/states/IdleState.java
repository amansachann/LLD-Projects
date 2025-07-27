package com.codewithaman.states;

import com.codewithaman.*;

// Idle State - ATM is waiting for the user to insert the card
public class IdleState implements AtmState{
    private final ATM atm;

    public IdleState(ATM atm) {
        this.atm = atm;
    }


    @Override
    public void insertCard(Card card) {
        System.out.println("✅ Card inserted: " + card.getCardNumber());

        // Get the account from the BankService and create a session
        BankService bank = BankService.getInstance();
        Account account = bank.getAccount(card.getLinkedAccoutNumber());

        if(account == null) {
            System.out.println("❌ Invalid card/account");
            return;
        }

        atm.setSession(new Session(card, account));
        atm.setCurrentState(new HasCardState(atm));
        System.out.println("\uD83D\uDCE5 Please enter your PIN: ");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("⚠\uFE0F No card inserted yet.");
    }

    @Override
    public void withdraw(int amount) {
        System.out.println("⚠\uFE0F Insert Card first.");
    }

    @Override
    public void deposit(int amount) {
        System.out.println("⚠\uFE0F Insert Card first.");
    }

    @Override
    public void checkBalance() {
        System.out.println("⚠\uFE0F Insert Card first.");
    }

    @Override
    public void ejectCard() {
        System.out.println("⚠\uFE0F No card to eject.");

    }
}
