package com.example.behavioral.chain_of_responsibility.first;
// 抽象账户类
public abstract class Account {
    protected Account successor;
    protected double balance;

    public void setNext(Account account) {
        this.successor = account;
    }

    public void pay(double amountToPay) {
        if (this.canPay(amountToPay)) {
            System.out.printf("Paid %.2f using %s%n", amountToPay, this.getClass().getSimpleName());
        } else if (this.successor != null) {
            System.out.printf("Cannot pay using %s. Proceeding ..%n", this.getClass().getSimpleName());
            this.successor.pay(amountToPay);
        } else {
            throw new RuntimeException("None of the accounts have enough balance");
        }
    }

    public boolean canPay(double amount) {
        return this.balance >= amount;
    }
}
