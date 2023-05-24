package oop.task20;

public class BankAccount {
    private long accountNumber;
    private double balance;

    public BankAccount(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public  void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if(amount > balance) {
            System.out.println("Недостаточно средств.");
        } else {
            balance -= amount;
            System.out.printf("C вашего аккаунто снято %.2f(грн.)", balance);
        }
    }
}
