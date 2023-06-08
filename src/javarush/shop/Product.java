package javarush.shop;

import java.util.Objects;

public class Product {
    private String name;
    private ProductDescription productDescription;
    private double price;

    public Product(String name, ProductDescription productDescription, double price) {
        this.name = name;
        this.productDescription = productDescription;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(String name) {
        this.name = name;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + price + '₴';
    }
}
