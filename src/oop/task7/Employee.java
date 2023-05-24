package oop.task7;

/*
Создайте класс Employee с приватными свойствами name, salary и методом getSalary(), а также класс Manager, который
наследуется от Employee и имеет дополнительное свойство bonus. Переопределите метод getSalary() в классе
 */
public class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}

class Manager extends Employee {
    private int bonus;

    public Manager(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public int getSalary() {
        return super.getSalary() + bonus;
    }
}
