package oop.task21;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Course> courses;

    public Department() {
        courses = new ArrayList<>(10);
    }

    public void addStudentToCourse(Student student, Course course) {
        List<Student> students = course.getStudentList();
        boolean isUnique = true;
            for (Student existingStudent : students) {
                if(existingStudent.getRegistrationNumber() == student.getRegistrationNumber()) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                students.add(student);
                System.out.printf("Студент %s зачисен на курс %s.%n", student.getName(), course.getName());
            } else {
                System.out.printf("Студент %s уже числиться на курсе %s.%n", student.getName(), course.getName());
            }
        }

    public void addProfessorToCourse(Professor professor, Course course) {

        if(professor.getCourse().equals(course.getName())) {
            course.setProfessor(professor);
            course.getProfessorList().add(professor);
            System.out.printf("Профессор %s назначен на курс %s%n", professor.getName(), course.getName());
        } else {
            System.out.println("К данному курсу профессор не подходит.");
        }

    }

    public void getInfoAboutStudents() {

        for (Course course : courses) {
            List<Student> students = course.getStudentList();
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void getInfoAboutCourses() {

        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void getInfoAboutProfessors() {

        for (Course c : courses) {
            List<Professor> professors = c.getProfessorList();
            for (Professor professor : professors) {
                System.out.println(professor);
            }
        }
    }

    public void addCourse(Course c) {
        System.out.printf("Курс %s добавлен в department.%n", c.getName());
        courses.add(c);
    }
}
