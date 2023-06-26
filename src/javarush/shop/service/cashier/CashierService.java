package javarush.shop.service.cashier;


import java.util.Set;

public interface CashierService {

    void addProductType(String productType);

    Set<String> getProductTypes();

    String getName();

    int getAgeExp();
}
