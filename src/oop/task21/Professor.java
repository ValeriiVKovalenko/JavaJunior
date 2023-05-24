package oop.task21;

public class Professor {
    private String name;
    private long id;
    private String course;

    @Override
    public String toString() {
        return "Professor{" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Professor(String name, long id, String course) {
        this.name = name;
        this.id = id;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
}
