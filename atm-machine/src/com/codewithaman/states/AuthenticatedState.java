package com.codewithaman.states;

import com.codewithaman.ATM;
import com.codewithaman.Account;
import com.codewithaman.Card;
import com.codewithaman.Session;

public class AuthenticatedState implements AtmState {

    private final ATM atm;

    public AuthenticatedState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("⚠\uFE0F Card already inserted.");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("⚠\uFE0F Card already inserted.");
    }

    @Override
    public void withdraw(int amount) {
        Session session = atm.getSession();
        Account account = session.getCurrentAccount();

        if(!atm.getDispenser().canDispene(amount)) {
            System.out.println("❌ Sorry, ATM doesn't have enough cash");
            return;
        }

        synchronized (account) {
            if(account.withdraw(amount)) {
                atm.getDispenser().dispense(amount);
                System.out.println("\uD83D\uDCB5 Please collect your cash.");
            } else {
                System.out.println("❌ Insufficient Balance");
            }
        }
    }

    @Override
    public void deposit(int amount) {
        Session session = atm.getSession();
        Account account = session.getCurrentAccount();

        synchronized (account){
            account.deposit(amount);
        }

        System.out.println("✅ Rs" + amount + " deposited successfully.");
    }

    @Override
    public void checkBalance() {
        Session session = atm.getSession();
        Account account = session.getCurrentAccount();

        System.out.println("\uD83D\uDCCA Your current balance: Rs" + account.getBalance());
    }

    @Override
    public void ejectCard() {
        atm.clearSession();
        atm.setCurrentState(new IdleState(atm));
        System.out.println("\uD83D\uDCB3 Card ejected. Thank you for using our ATM service");
    }
}
