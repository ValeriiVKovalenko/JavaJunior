package oop.task17;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("1", "Valerii", 3000.0);
        BankAccount bankAccount2 = new BankAccount("2", "Ivan", 5000.0);

        bankAccount1.deposit(2000.0);
        bankAccount1.transferFunds(bankAccount2, 5000.0);
        System.out.println(bankAccount2.getBalance());

        CheckingAccount checkingAccount = new CheckingAccount(
                "4", "Mamuka", 9500.0);

        checkingAccount.setOverdraftLimit(2000.0);
        checkingAccount.debitCardPayment(5000.0);

        System.out.println(checkingAccount.getBalance());
    }
}
