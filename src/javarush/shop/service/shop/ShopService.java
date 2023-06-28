package javarush.shop.service.shop;

import javarush.shop.model.Warehouse;
import javarush.shop.model.Cashier;
import javarush.shop.model.Product;
import javarush.shop.service.payment.PaymentService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ShopService {
    Map<String, List<Product>> getProductsByType();

    void transferItemToClient(String clientName, Product product, String type, int count);

    void returnProductFromClient(String clientName, String productName, int count);


    Cashier getCashierByProductType(String productType);


    Warehouse getWarehouse();

    boolean hasProductByName(String name);

    boolean hasProductSufficientCount(String name, int count);

    PaymentService getPaymentService();

}
