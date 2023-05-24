package oop.task5;
/*
Создайте класс Shape с абстрактным методом calculateArea(). Создайте классы Circle и Rectangle, которые наследуются от
Shape и реализуют метод calculateArea() для расчета площади круга и прямоугольника соответственно. Создайте экземпляры
классов Circle и Rectangle и выведите их площади.
 */
public abstract class Shape {

    public Shape() {
    }

    public abstract double calculateArea();
}

class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return (double) width * height;
    }
}

class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(4);
        Rectangle rectangle = new Rectangle(4, 5);

        System.out.println(circle.calculateArea());
        System.out.println(rectangle.calculateArea());
    }
}
