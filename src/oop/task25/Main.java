package oop.task25;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Java", "Джошуа Блох");
        Book book2 = new Book("Том Соер", "Джек Лондон");
        Book book3 = new Book("Консуело", "Джодж Санд");

        Reader reader1 = new Reader("Kovalenko V.I", "129",
                "Фантастика", "23.01.95", "+38087698732");
        Reader reader2 = new Reader("Ivanov I.I.", "11",
                "Драма", "22.03.93", "+38047548731");
        Reader reader3 = new Reader("Сидоров И.В.", "9",
                "Наука", "23.05.97", "+38086432732");
        Reader reader4 = new Reader("Мамаев В.Л.", "1",
                "Ужасы", "22.06.21", "+38454698722");

        DataBase dataBase = new DataBase();

        dataBase.addReader(reader1);
        dataBase.addReader(reader2);
        dataBase.addReader(reader3);
        dataBase.addReader(reader4);

        reader1.takeBook("Мир, Шляпа, Восток");
        reader2.takeBook(book1, book2);
    }
}
