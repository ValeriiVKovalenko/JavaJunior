package oop.task25;

public class Book {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }
}
