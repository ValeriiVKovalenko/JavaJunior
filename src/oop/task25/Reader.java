package oop.task25;

import Bruce_Eckel.Kapitel7.art.mini_task.B;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Reader {
    private String fullName;
    private String libraryCardNumber;
    private String faculty;
    private String dateOfBirth;
    private String phoneNumber;

    public Reader(String fullName, String libraryCardNumber, String faculty, String dateOfBirth, String phoneNumber) {
        this.fullName = fullName;
        this.libraryCardNumber = libraryCardNumber;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void takeBook(int count) {
        System.out.printf("%s взял %d книг(у).%n", getFullName(), count);
    }

    public void takeBook(String...booksName) {
        System.out.printf("%s взял книги: %s%n", getFullName(), Arrays.toString(booksName));
    }

    public void takeBook(Book... books) {
        System.out.printf("%s взял книги: ", getFullName());
        for (Book book : books) {
            System.out.print(book.getName() + "(" + book.getAuthor() + "), " );
        }
        System.out.println();
    }


    public void returnBook(int count) {
        System.out.printf("%s вернул %d книг(у).%n", getFullName(), count);
    }

    public void returnBook(String...booksName) {
        System.out.printf("%s вернул книги: %s%n", getFullName(), Arrays.toString(booksName));
    }

    public void returnBook(Book... books) {
        System.out.printf("%s вернул книги: ", getFullName());
        for (Book book : books) {
            System.out.print(book.getName() + "(" + book.getAuthor() + ") " );
        }
        System.out.println();
    }
}
