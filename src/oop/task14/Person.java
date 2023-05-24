package oop.task14;
/*
Создайте классы Person, Teacher, Student и Course. Класс Person должен содержать свойства name и `age
 */
public abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person() {
    }
}

class Teacher extends Person {
    public Teacher(String name, int age) {
        super(name, age);
    }
}

class Student extends Person {
    Course course;
    public Student(String name, int age, Course course) {
        super(name, age);
        this.course = course;
    }
}

class Course {
}