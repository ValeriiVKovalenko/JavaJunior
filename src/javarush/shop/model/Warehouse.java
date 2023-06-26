package javarush.shop.model;

import java.util.*;

public class Warehouse {
    private final Map<Product, Integer> productMap = new HashMap<>();

    public Set<String> getProductTypes() {
        Set<String> productTypes = new HashSet<>();
        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            productTypes.add(entry.getKey().getProductDescription().getType());
        }
        return productTypes;
    }

    public Map<String, List<Product>> getProductsByType() {
        Map<String, List<Product>> productsByType = new HashMap<>();

        for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            Product product = entry.getKey();
            String productType = entry.getKey().getProductDescription().getType();

            productsByType.computeIfAbsent(productType, key -> new ArrayList<>())
                    .add(product);
        }
        return productsByType;
    }

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

    public boolean hasProduct(String productName) {
       for (Map.Entry<Product, Integer> entry : productMap.entrySet()) {
           String name = entry.getKey().getName();

           if (productName.equals(name)) {
               return true;
           }
       }
       return false;
    }

    public Map<Product, Integer> getProductMap() {
        return productMap;
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
