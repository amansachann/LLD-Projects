package com.codewithaman;

public class Account {
    private String accountNumber;
    private int balance;

    public Account(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public synchronized void deposit(int amount) {
        this.balance += amount;
    }

    public synchronized boolean withdraw(int amount) {
        if(this.balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public int getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
