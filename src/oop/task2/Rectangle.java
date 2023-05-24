package oop.task2;

/*
Создайте класс Rectangle, содержащий свойства width и height, а также методы getArea()
(возвращает площадь прямоугольника) и getPerimeter() (возвращает периметр прямоугольника).
Создайте экземпляр класса Rectangle и выведите его площадь и периметр.
 */
public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getArea() {
        return width * height * 0.5;
    }

    public double getPerimeter() {
        return 2 * Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2)) + 2 * width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5,10);
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
    }
}

