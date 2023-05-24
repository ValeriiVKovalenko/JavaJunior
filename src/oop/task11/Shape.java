package oop.task11;
/*
Создайте класс Shape, представляющий геометрическую фигуру, с абстрактными методами calculateArea() (расчет площади)
и calculatePerimeter() (расчет периметра). Реализуйте классы Circle, Rectangle и Triangle, которые наследуются от
Shape и реализуют соответствующие методы для расчета площади и периметра.
 */
public abstract class Shape {
    public abstract double calculateArea();

    public abstract double calculatePerimeter();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * Math.pow(radius, 2);
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

class Triangle extends Shape {
    private double height;
    private double width;

    public Triangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return height * width * 0.5;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2)) + 2 * height;
    }
}
