package oop.task22;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone("+380957643215", "Iphone 10", 0.5);
        Phone phone2 = new Phone("+380958765467", "Iphone 13", 0.4);
        Phone phone3 = new Phone("+380953546546", "Iphone 12", 0.35);

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);
        System.out.println("=========");

        phone1.receiveCall("Иван", "+380932747649");
        System.out.println(phone1.getNumber());

        phone1.receiveCall("Валерий");
        System.out.println(phone2.getNumber());

        phone1.receiveCall("Мамука");
        System.out.println(phone3.getNumber());
    }
}
