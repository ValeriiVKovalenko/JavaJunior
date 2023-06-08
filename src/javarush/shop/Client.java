package javarush.shop;

import java.util.HashMap;
import java.util.Map;

public class Client {

    private String name;
    private double balance;
    private Map<Product, Integer> basket;

    public Client(String name, double balance) {
        this.name = name;
        this.balance = balance;
        basket = new HashMap<>();
    }

    public void addItemToBasket(Product product, int count) {
        if (basket.containsKey(product)) {
            basket.put(product, basket.get(product) + count);
        } else {
            basket.put(product, count);
        }
    }

    public void removeItemFromBasket(Product product, int count) {
        int currentQuantity = basket.getOrDefault(product, 0);
        if (currentQuantity > count) {
            basket.put(product, currentQuantity - count);
        } else {
            basket.remove(product);
        }
    }
    public void removeItemFromBasket(Product product) {
      basket.remove(product);
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
