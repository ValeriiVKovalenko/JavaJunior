package oop.task20;
/*
Задача: Создание системы банковских счетов
Разработайте классы BankAccount, SavingsAccount и CheckingAccount, которые представляют различные типы банковских
счетов. Учтите следующие требования:
BankAccount должен иметь базовые свойства и методы, такие как номер счета, баланс, методы для внесения и снятия денег
и т.д.
SavingsAccount должен наследовать от BankAccount и добавлять функциональность, связанную с накопительным счетом,
такую как начисление процентов.
CheckingAccount должен наследовать от BankAccount и добавлять функциональность, связанную с текущим счетом, такую как
возможность овердрафта и определенные ограничения на операции.
 */
public class Main {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount(33L, 8700.20);
        checkingAccount.setLimit(3000);
        checkingAccount.withdraw(4000);
        System.out.println(checkingAccount.getBalance());
    }
}
