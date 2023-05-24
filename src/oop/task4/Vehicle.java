package oop.task4;
/*
Создайте классы Vehicle и Car, где Vehicle является базовым классом, а Car наследуется от Vehicle. Vehicle
должен иметь свойства brand и year, а также метод startEngine(), который выводит сообщение "Engine started"
.Car должен иметь дополнительное свойство color и переопределенный метод startEngine(), который выводит сообщение
"Car engine started". Создайте экземпляр класса Car и вызовите метод startEngine().
 */
public class Vehicle {
    private int year;
    private String brand;

    public Vehicle(int year, String brand) {
        this.year = year;
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void startEngine() {
        System.out.println("Engine started");
    }

    public String getBrand() {
        return brand;
    }
}

class Car extends Vehicle {
    private String color;

    public Car(int year, String brand, String color) {
        super(year, brand);
        this.color = color;
    }

    @Override
    public void startEngine() {
        System.out.println("Car engine started");
    }
}

class Main {
    public static void main(String[] args) {
        Car car = new Car(1999, "Toyota", "black");
        car.startEngine();
    }
}