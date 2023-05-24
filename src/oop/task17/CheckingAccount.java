package oop.task17;

public class CheckingAccount extends BankAccount {
    private double limit;

    public CheckingAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
        limit = 10000.0;
    }

    public void debitCardPayment(double amount) {
        if(super.getBalance() > amount) {
            if(amount < limit) {
                super.setBalance(super.getBalance() - amount);
                System.out.printf("Платеж на сумму %.2f(грн) утвержден.", amount);
            } else {
                System.out.println("Операция невозможна, проверте лимит на Вашей карте.");
            }
        } else {
            System.out.println("Недостаточно средств на карте.");
        }

    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    public void setOverdraftLimit(double limit) {
        this.limit = limit;
    }
}
