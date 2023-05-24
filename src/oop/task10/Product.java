package oop.task10;

import java.util.ArrayList;
import java.util.List;

/*
Создайте класс Product, который представляет товар и имеет свойства name, price и quantity. Реализуйте методы для
увеличения и уменьшения количества товара, а также для расчета общей стоимости товара (цена * количество). Создайте
класс Cart, который содержит список товаров (Product) и методы для добавления товаров в корзину, удаления товаров из
корзины и расчета общей стоимости товаров в корзине.
 */
public class Product {
    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseProduct(int number) {
        quantity += number;
    }

    public void decreaseProduct(int number) {
        quantity -= number;
    }

    public int totalCost() {
        return price * quantity;
    }
}

class Cart {
    private List<Product> cart;

    public Cart() {
        cart = new ArrayList<>(10);
    }

    public void addProductInCart(Product product) {
        cart.add(product);
    }

    public void removeProductFromCart(Product product) {
        cart.remove(product);
    }

    public void totalCost() {
        int sum = 0;
        for(Product product : cart) {
            sum += product.totalCost();
        }
        System.out.println("Общая сумма собестоимости товаров составляет: " + sum);
    }
}

class Main {
    public static void main(String[] args) {
        Product apple = new Product("Apple", 20, 5);
        Product water = new Product("Water", 10, 2);
        Product bread = new Product("Bread", 3, 1);

        Cart cart = new Cart();
        cart.addProductInCart(apple);
        cart.addProductInCart(water);
        cart.addProductInCart(bread);
        apple.increaseProduct(3);

        cart.removeProductFromCart(bread);

        cart.totalCost();
    }
}
