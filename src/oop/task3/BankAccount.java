package oop.task3;
/*
Создайте класс BankAccount, содержащий свойства accountNumber, balance и методы deposit(amount) (пополняет баланс
на указанную сумму) и withdraw(amount) (снимает указанную сумму с баланса). Создайте экземпляр класса BankAccount,
выполните несколько операций пополнения и снятия денег и выведите баланс.
 */
public class BankAccount {
    private int accountNumber;
    private int balance;

    public BankAccount(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int deposit(int amount) {
        return balance += amount;
    }

    public int withdraw(int amount) {
        return balance -= amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1, 4000);
        System.out.println(bankAccount.deposit(1000));
        System.out.println(bankAccount.withdraw(3000));
        System.out.println(bankAccount);
    }
}
