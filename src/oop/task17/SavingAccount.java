package oop.task17;

public class SavingAccount extends BankAccount{
    private double interestRate;

    public SavingAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
        interestRate = 0.2;
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calculateInterestRate() {
        return getBalance() * (interestRate / 100);
    }


}
