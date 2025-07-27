package com.codewithaman;

public class Main {
    public static void main(String[] args) {
        // Get the singleton ATM instance
        ATM atm = ATM.getInstance();

        // Simulate inserting card
        Card card = new Card("CARD123", "ACC123");
        atm.insertCard(card); // Moves to HasCardState

        // Simulate entering correct PIN
        atm.enterPin("1234"); // Moves to AuthenticatedState

        // Simulate operations
        atm.checkBalance();          // Show balance
        atm.withdraw(370);           // Withdraw ₹370
        atm.deposit(500);            // Deposit ₹500
        atm.checkBalance();          // Check balance again
        atm.ejectCard();             // End session, back to IdleState
    }
}
