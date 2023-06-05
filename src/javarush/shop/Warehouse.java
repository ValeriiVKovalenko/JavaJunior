package javarush.shop;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<Product, Integer> productMap = new HashMap<>();

    public void addProduct(Product product, Integer count) {
        if(productMap.containsKey(product)) {
            productMap.put(product, productMap.get(product) + count);
        } else {
            productMap.put(product, count);
        }
    }
    public void removeProduct(Product product, Integer count) {
      if (productMap.containsKey(product) && productMap.get(product) >= count) {
           Integer currentCount = productMap.get(product);
           productMap.put(product, currentCount - count);
       }
    }

    public boolean hasProduct(Product product) {
        return productMap.containsKey(product);
    }

    public void findProductByName(String productName) {
        boolean isFound = false;
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getName().equals(productName)) {
                System.out.printf("Product %s is find.%n", productName);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.printf("Product %s is not found.", productName);
        }
    }

    public void print() {
        System.out.println("Warehouse contents:");
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            Product product = entry.getKey();
            int count = entry.getValue();
            System.out.println(product.getName() + ": " + count);
        }
    }


}
