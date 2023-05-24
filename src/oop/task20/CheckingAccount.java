package oop.task20;

public class CheckingAccount extends BankAccount {

    private double limit;
    private double overdraft;

    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
        limit = 3500.00;
        overdraft = 1500.00;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        if(amount > super.getBalance() && amount > super.getBalance() + overdraft) {
            System.out.println("Недостаточно средств.");
        } else if(amount > limit){
            System.out.println("Превышение лимита. Установите больше лимит.");
        } else {
            double result = super.getBalance();
            result -= amount;
            System.out.printf("C вашего аккаунто снято %.2f(грн.)", result);
        }
    }

}
