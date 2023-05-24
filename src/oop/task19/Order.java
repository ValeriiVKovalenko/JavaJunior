package oop.task19;

import java.util.List;

public class Order {

    private long id;
    private List<Product> customerProductList;
    private double totalAmount;

    public void addItem(Product product) {
        customerProductList.add(product);
    }

    public void removeItem(Product product) {
        customerProductList.remove(product);
    }

    public double calculateTotalAmount() {
        for (Product product : customerProductList) {
            totalAmount += product.getPrice();
        }
        return totalAmount;
    }

}
