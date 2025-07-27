package com.codewithaman.states;

import com.codewithaman.Card;

public interface AtmState {
   void insertCard(Card card);
   void enterPin(String pin);
   void withdraw(int amount);
   void deposit(int amount);
   void checkBalance();
   void ejectCard();
}
