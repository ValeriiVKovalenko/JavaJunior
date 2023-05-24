package oop.task21;

public class Student {
    private String name;
    private long registrationNumber;

    public Student(String name, long registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" + name + '\'' +
                ", registrationNumber=" + registrationNumber +
                '}';
    }

    public long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

}
