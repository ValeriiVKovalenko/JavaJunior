package oop.task19;

public class Product {
    private String name;
    private double price;
    private String producer;
    private String lifeSpan;

    public Product(String name, double price, String producer, String lifeSpan) {
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.lifeSpan = lifeSpan;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getProducer() {
        return producer;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public void getInfoAboutProduct() {
        System.out.printf("Продукт %s изготовлен компанией %s.\nЦена: %.2f\nСрок службы: %s",
                getName(), getProducer(), getPrice(), getLifeSpan());
    }
}
