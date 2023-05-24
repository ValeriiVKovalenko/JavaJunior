package oop.task17;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;


    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
    public void transferFunds(BankAccount anotherAccount, double amount) {
        if(balance >= amount) {
            balance -= amount;
            anotherAccount.balance += amount;
            System.out.printf("Операция проведена успешна.\nПереведено %.2f(грн) на аккаунт %s. " +
                            "На текущем счету у Вас: %.2f(грн)\n",
                    amount, anotherAccount.getAccountHolderName(), balance);
        } else {
            System.out.println("Недостаточно средств на счету");
        }
    }
}
