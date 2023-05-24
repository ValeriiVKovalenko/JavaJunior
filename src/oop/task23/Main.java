package oop.task23;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Person person2 = new Person("Valerii Kovalneko", 28);

        person2.move();
        person2.talk();
        System.out.println("======");

        person.talk();
        person.talk();
    }
}
