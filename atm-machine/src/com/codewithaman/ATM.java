package com.codewithaman;

import com.codewithaman.dispenser.CashDispenser;
import com.codewithaman.dispenser.DispenserFactory;
import com.codewithaman.states.AtmState;
import com.codewithaman.states.IdleState;

public class ATM {

    private static ATM instance;

    private AtmState currentState;
    private Session session;
    private CashDispenser dispenser;


    private ATM() {
        this.currentState = new IdleState(this);
        this.session = null;
        this.dispenser = new CashDispenser(DispenserFactory.createChain());
    }

    public static synchronized ATM getInstance() {
        if(instance == null) {
            instance = new ATM();
        }
        return instance;
    }


    public AtmState getCurrentState() {
        return currentState;
    }

    public Session getSession() {
        return session;
    }

    public CashDispenser getDispenser() {
        return dispenser;
    }

    public void setCurrentState(AtmState currentState) {
        this.currentState = currentState;
    }

    public void clearSession() {
        this.session = null;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void setDispenser(CashDispenser dispenser) {
        this.dispenser = dispenser;
    }

    // Public methods for user delegation (delegated to current state)
    public void insertCard(Card card) {
        currentState.insertCard(card);
    }

    public void enterPin(String pin) {
        currentState.enterPin(pin);
    }

    public void withdraw(int amount) {
        currentState.withdraw(amount);
    }
    public void deposit(int amount) {
        currentState.deposit(amount);
    }

    public void checkBalance() {
        currentState.checkBalance();
    }

    public void ejectCard() {
        currentState.ejectCard();
    }
}
