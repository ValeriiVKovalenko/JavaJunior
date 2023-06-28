package javarush.shop.model;

import java.util.Set;

public class Cashier {
    private final Long id;
    private final String name;
    private final int ageExp;
    private final Set<String> productTypes;

    public Cashier(Long id, String name, int ageExp, Set<String> productTypes) {
        this.id = id;
        this.name = name;
        this.ageExp = ageExp;
        this.productTypes = productTypes;
    }

    public Set<String> getProductTypes() {
        return productTypes;
    }

    public String getName() {
        return name;
    }

}
