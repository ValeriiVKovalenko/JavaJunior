package oop.task12;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    /*
Создайте класс Employee с свойствами name, position и salary. Создайте класс Company, который содержит список
сотрудников (Employee) и методы для добавления нового сотрудника, удаления сотрудника, вывода списка всех сотрудников
и расчета средней зарплаты. Добавьте методы для повышения зарплаты сотрудникам определенной должности.
     */

    private String name;
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        if(position.equals("Senior")) {
            return salary + salary * 1.5;
        } else {
            return salary;
        }
    }
}

class Company {
    private List<Employee> employeeList;

    public Company() {
        employeeList = new ArrayList<>(5);
    }

    public void addEmployee(Employee emp) {
        employeeList.add(emp);
    }

    public void removeEmployee(Employee emp) {
        employeeList.remove(emp);
    }

    public int averageSalary() {
        int sum = 0;
        for (Employee emp : employeeList) {
            sum += emp.getSalary();
        }
        return sum / employeeList.size();
    }
}

class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Valerii", "Junior", 300);
        Employee emp2 = new Employee("Andreiy", "Middle", 1500);
        Employee emp3 = new Employee("Valerii", "Senior", 2500);

        Company company = new Company();
        company.addEmployee(emp1);
        company.addEmployee(emp2);
        company.addEmployee(emp3);
        company.removeEmployee(emp3);

        System.out.println(company.averageSalary());
    }
}
