package oop.task15;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Создайте класс University, который содержит список факультетов (Faculty) и методы для добавления нового факультета,
поиска факультета по имени и вывода всех факультетов в университете. Класс Faculty должен иметь свойства name, dean
и список студентов (Student), а также методы для добавления и удаления студентов.
 */
public class University {
    private List<Faculty> facultyList;

    public University() {
        facultyList = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        if(!facultyList.contains(faculty)) {
            facultyList.add(faculty);
        }
    }

    public void searchFaculty(String name) {
        for(Faculty faculty : facultyList) {
            if(faculty.getName().equals(name)) {
                System.out.println(faculty);
            }
        }
    }

    public void showAllFaculty() {
        for (Faculty faculty : facultyList) {
            System.out.println(faculty);
        }
    }


}

class Faculty {
    private String name;
    private String dean;
    private List<Student> studentList;

    public String getName() {
        return name;
    }

    public Faculty(String name, String dean) {
        this.name = name;
        this.dean = dean;
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", dean='" + dean + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dean);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Faculty faculty = (Faculty) obj;
        return Objects.equals(name, faculty.name) && Objects.equals(dean, faculty.dean);
    }
}

class Student {
    private String name;
    private String lastname;
    private int course;
    private double avgGrade;

    public Student(String name, String lastname, int course, double avgGrade) {
        this.name = name;
        this.lastname = lastname;
        this.course = course;
        this.avgGrade = avgGrade;
    }
}

class Main {
    public static void main(String[] args) {
        Student st1 = new Student("Valerii", "Kovalenko", 4, 5.5);
        Student st2 = new Student("Mamuka", "Dzakeli", 5, 7.5);
        Student st3 = new Student("Max", "Pavlenko", 3, 4.5);

        Faculty faculty1 = new Faculty("Информатика", "Глайко");
        Faculty faculty2 = new Faculty("Машиностроение", "Иванов");
        Faculty faculty3 = new Faculty("Выш мат", "Пупкин");
        Faculty faculty4 = new Faculty("Выш мат", "Пупкин");

        faculty1.addStudent(st1);
        faculty2.addStudent(st2);
        faculty3.addStudent(st3);

        University university = new University();

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
        university.addFaculty(faculty3);
        university.addFaculty(faculty4);

        university.searchFaculty("Информатика");

        university.showAllFaculty();

    }
}
