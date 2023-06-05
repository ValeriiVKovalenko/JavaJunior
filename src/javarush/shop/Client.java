package javarush.shop;

import java.util.HashMap;
import java.util.Map;

public class Client {

    private String name;
    private double balance;
    private Shop shop;
    private Map<Product, Integer> basket;

    public Client(String name, double balance, Shop shop) {
        this.name = name;
        this.balance = balance;
        this.shop = shop;
        basket = new HashMap<>();
    }

    public void buyItemFromBasket() {
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            Product product = entry.getKey();
            int currentCount = entry.getValue();
            Cashier cashier = findCashierForProduct(product);

            if (cashier != null) {
                cashier.sellItemToClient(product, currentCount, this, balance);
            }
        }
        basket.clear();
    }

    public void returnItemToShop(Product product, int count) {
        addItemToBasket(product, count);
        Cashier cashier = findCashierForProduct(product);
        if (cashier != null) {
            cashier.returnProductFromClient(product, count, this);
        }
        basket.clear();
    }

    private Cashier findCashierForProduct(Product product) {
        for (Cashier cashier : shop.getCashiers()) {
            if (cashier.canSellProduct(product)) {
                return cashier;
            }
        }
        return null;
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

    public void findItemByName(String productName) {
        shop.getWarehouse().findProductByName(productName);
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
