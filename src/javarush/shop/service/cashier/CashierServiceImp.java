package javarush.shop.service.cashier;

import javarush.shop.model.Product;

import java.util.HashSet;
import java.util.Set;

public class CashierServiceImp implements CashierService {
    private String name;
    private int ageExp;
    private final Set<String> productTypes;

    public CashierServiceImp() {
        productTypes = new HashSet<>();
    }

    @Override
    public void addProductType(String productType) {
        productTypes.add(productType);
    }

    @Override
    public Set<String> getProductTypes() {
        return productTypes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAgeExp() {
        return ageExp;
    }
}
