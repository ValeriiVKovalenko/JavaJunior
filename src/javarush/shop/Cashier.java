package javarush.shop;

import java.util.HashSet;
import java.util.Set;

public class Cashier {

    private String name;
    private int ageExp; // лет опыта
    private final Set<String> productTypes;

    public Cashier(String name, int ageExp) {
        this.name = name;
        this.ageExp = ageExp;
        productTypes = new HashSet<>();
    }

    public double calculateTotalPrice(Product product, int count) {
        return product.getPrice() * count;
    }

    public void addProductType(String productType) {
        productTypes.add(productType);
    }

    public Set<String> getProductTypes() {
        return productTypes;
    }

    public String getName() {
        return name;
    }

    public int getAgeExp() {
        return ageExp;
    }
}
