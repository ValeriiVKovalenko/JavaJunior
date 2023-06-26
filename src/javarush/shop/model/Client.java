package javarush.shop.model;

import java.util.HashMap;
import java.util.Map;

public class Client {
    private String name;
    private double balance;
    private Map<Product, Integer> basket;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasket(Map<Product, Integer> basket) {
        this.basket = basket;
    }

    public Client(String name, double balance) {
        this.name = name;
        this.balance = balance;
        basket = new HashMap<>();
    }

    public Map<Product, Integer> getBasket() {
        return basket;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
