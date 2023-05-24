package oop.task8;

import java.util.ArrayList;
import java.util.List;

/*
Создайте класс Library, который содержит список книг (Book) и методы для добавления новых книг, поиска книги по
названию и вывода всех книг в библиотеке. Класс Book должен иметь свойства title, author и year.
 */
public class Library {
    private List<Book> bookList;

    public Library() {
        bookList = new ArrayList<>(20);
    }

    public void addBook(Book b) {
        bookList.add(b);
    }

    public Book findBook(String title) {
        for (int i = 0; i < bookList.size(); i++) {
            if(bookList.get(i).getTitle().equals(title)) {
                return bookList.get(i);
            }
        }
        return null;
    }

    public void showAllBooks() {
         for (Book book : bookList) {
             System.out.println(book);
         }
    }
}

class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Мартин Иден", "Джек Лондон", 1909);
        Book b2 = new Book("Красное и черное", "Стендаль", 1830);
        Book b3 = new Book("Консуело", "Джорд Санд", 1843);
        Book b4 = new Book("Дети капитана Гранта", "Жуль Верн", 1867);
        Book b5 = new Book("Философия Java", "Брюс Эккель", 2006);

        Library library = new Library();
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);
        library.addBook(b5);

        System.out.println(library.findBook("Философия Java"));
        System.out.println();
        library.showAllBooks();
    }
}
