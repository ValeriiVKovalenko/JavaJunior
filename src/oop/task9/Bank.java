package oop.task9;

import java.util.ArrayList;
import java.util.List;

/*
Создайте класс Bank, который содержит список банковских счетов (BankAccount) и методы для открытия нового счета,
закрытия счета, пополнения и снятия денег со счета, а также вывода общего баланса всех счетов в банке. Класс
BankAccount должен иметь свойства accountNumber, balance и методы для работы со счетом.
 */
public class Bank {
    private List<BankAccount> bankAccountList;

    public Bank() {
        bankAccountList = new ArrayList<>(20);
    }

    public void addBankAccount(BankAccount bankAccount) {
        if(!bankAccountList.contains(bankAccount)) {
            bankAccountList.add(bankAccount);
        }
    }

    public void closeBankAccount(BankAccount bankAccount) {
       bankAccountList.remove(bankAccount);
    }

    public void deposit(BankAccount bankAccount, int amount) {
        bankAccount.deposit(amount);
    }

    public void withdraw(BankAccount bankAccount, int amount) {
        bankAccount.withdrawal(amount);
    }


    public void showBalanceOfAllBankAccounts() {
        int sum = 0;
        for (BankAccount bankAccount : bankAccountList) {
            sum += bankAccount.getBalance();
        }
        System.out.println("Баланс всех аккаунтов: " + sum);
    }
}

class BankAccount {
    private int accountNumber;
    private int balance;

    public BankAccount(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdrawal(int amount) {
        balance -= amount;
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
        BankAccount bankAccount1 = new BankAccount(1, 4000);

        Bank bank = new Bank();
        bank.addBankAccount(bankAccount1);
        System.out.println(bankAccount1.getBalance());
        bank.deposit(bankAccount1, 4000);
        System.out.println(bankAccount1.getBalance());
        bank.withdraw(bankAccount1, 3000);
        System.out.println(bankAccount1.getBalance());

        bank.closeBankAccount(bankAccount1);
        bank.deposit(bankAccount1, 1000);
        bank.showBalanceOfAllBankAccounts();





    }
}
