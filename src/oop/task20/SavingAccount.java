package oop.task20;

public class SavingAccount extends BankAccount {
    private static final double INTEREST_RATE = 3.5;

    public SavingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double getInterestRate() {
        return INTEREST_RATE;
    }

    public void calculateInterestRate() {
        double result = super.getBalance();
        result  += super.getBalance() * INTEREST_RATE;
        System.out.printf("Текущая сумма на вашем счету: %.2f(грн.)%nПри процентной ставке %.1f%% ваша сумма будет: %.2f",
                super.getBalance(), INTEREST_RATE, result);
    }

}
