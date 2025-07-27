package com.codewithaman;

public class Card {
    private String cardNumber;
    private String linkedAccoutNumber;

    public Card(String cardNumber, String linkedAccoutNumber) {
        this.cardNumber = cardNumber;
        this.linkedAccoutNumber = linkedAccoutNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getLinkedAccoutNumber() {
        return linkedAccoutNumber;
    }
}
