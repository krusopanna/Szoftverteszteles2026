package hu.example;

public class BankAccount {

    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("A befizetés összege pozitív kell legyen!");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("A felvétel összege pozitív kell legyen!");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Nincs elegendő egyenleg a számlán!");
        }
        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }
}