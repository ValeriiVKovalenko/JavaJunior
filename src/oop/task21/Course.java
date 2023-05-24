package oop.task21;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private Professor professor;
    private List<Student> students;
    private List<Professor> professors;

    public Course(String name) {
        this.name = name;
        students = new ArrayList<>(10);
        professors = new ArrayList<>(10);
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Course{" + name + '\'' +
                ", " + professor +
                ", students=" + students +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudentList() {
        return students;
    }

    public List<Professor> getProfessorList() {
        return professors;
    }

    public Professor getProfessor() {
        return professor;
    }
}
