package javarush.shop.service.client;

import javarush.shop.model.Client;
import javarush.shop.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface ClientService {
    void addItemToBasket(String name, Long productId, int count);

    boolean isProductInBasketExist(String clientName, Long productId);

    void removeItemFromBasket(String clientName, Long productId);

    void removeItemFromBasket(String clientName, Long productId, int productCount);

    Map<Product, Integer> getBasket(String clientName);

    BigDecimal getBalance(String clientName);

    void saveClient(String name, BigDecimal balance);

    boolean isClientExist(String clientName);

    Client getClientByName(String name);

    Long getClientId(String name);

    boolean isProductSufficientInBasketExist(String clientName, Long productId, int selectedCount);

    void subtractBalance(String clientName, BigDecimal totalPrice);

    void addBalance(String clientName, BigDecimal refundAmount);
}
