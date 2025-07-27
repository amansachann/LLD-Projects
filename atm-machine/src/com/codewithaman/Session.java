package com.codewithaman;

public class Session {
     private Card currentCard;
     private Account currentAccount;

    public Session(Card currentCard, Account currentAccount) {
        this.currentCard = currentCard;
        this.currentAccount = currentAccount;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }
}
