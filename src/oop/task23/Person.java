package oop.task23;

public class Person {

    private String fullName;
    private int age;

    public void talk() {
        System.out.println("Такой-то " + fullName + " говорит.");
    }

    public void move() {
        System.out.println("Такой-то " + fullName + " идет.");
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public Person() {
    }
}
