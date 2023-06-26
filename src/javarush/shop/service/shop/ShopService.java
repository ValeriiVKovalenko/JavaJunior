package javarush.shop.service.shop;

import javarush.shop.model.Warehouse;
import javarush.shop.model.Cashier;
import javarush.shop.model.Product;

import java.util.List;
import java.util.Map;

public interface ShopService {
    Map<String, List<Product>> getProductsByType();

    void transferItemToClient(Cashier cashier, Product product, int count);

    void returnProductFromClient(Cashier cashier, Product product, int count);

    boolean canSellProduct(Cashier cashier, Product product);

    Cashier getCashierByProductType(String productType);

    Map<Product, Integer> getProducts();

    Map.Entry<Product, Integer> getProductEntryByName(String name, Map<Product, Integer> basket);

    Map.Entry<Product, Integer> getProductEntryByName(String name);

    List<Cashier> getCashiers();

    boolean hasProduct(Product product);

    double getBank();

    Warehouse getWarehouse();

    void setBank(double bank);

    boolean hasProductName(String name);
}
