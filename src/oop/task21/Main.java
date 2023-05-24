package oop.task21;

/*
Задача: Моделирование системы университета
Разработайте классы для моделирования системы университета. Рассмотрите классы Student, Professor, Course и Department.
Учтите следующие требования:
Student должен иметь свойства, связанные с именем, регистрационным номером, курсами, на которые он записан, и т.д.
Professor должен иметь свойства, связанные с именем, ID, преподаваемыми курсами, и т.д.
Course должен иметь свойства, связанные с названием, преподавателем, студентами, и т.д.
Department должен содержать информацию о курсах, студентах и профессорах, принадлежащих к данному отделению.
 */
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Valerii", 1L);
        Student student2 = new Student("Ivan", 2L);
        Student student3 = new Student("Mamuka", 3L);

        Professor professor1 = new Professor("Bah", 6L, "Musik");
        Professor professor2 = new Professor("Einstein", 7L, "Phyzik");

        Course course1 = new Course("Musik");
        Course course2 = new Course("Phyzik");


        Department department = new Department();
        department.addCourse(course1);
        department.addCourse(course2);

        department.addStudentToCourse(student1, course1);
        department.addStudentToCourse(student1, course2);
        department.addStudentToCourse(student2, course1);
        department.addStudentToCourse(student2, course2);
        department.addStudentToCourse(student3, course1);
        department.addStudentToCourse(student3, course2);

        department.addProfessorToCourse(professor1, course1);
        department.addProfessorToCourse(professor2, course2);

        department.getInfoAboutStudents();
        department.getInfoAboutProfessors();

        department.getInfoAboutCourses();

    }
}
