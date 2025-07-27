package com.codewithaman;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankService {

    private static BankService instance = null;

    private final Map<String, Account> accountMap = new ConcurrentHashMap<>();
    private final Map<String, String> cardPinMap = new ConcurrentHashMap<>();

    public BankService() {
        // mock data
        Account acc = new Account("ACC123", 5000);
        accountMap.put("ACC123", acc);
        cardPinMap.put("CARD123", "1234");
    }

    public static synchronized BankService getInstance() {
        if(instance == null) {
            instance = new BankService();
        }
        return instance;
    }

    public Account getAccount(String linkedAccoutNumber) {
        return accountMap.get(linkedAccoutNumber);
    }

    public boolean validatePin(Card card,String pin) {
        return pin.equals(cardPinMap.get(card.getCardNumber()));
    }
}
