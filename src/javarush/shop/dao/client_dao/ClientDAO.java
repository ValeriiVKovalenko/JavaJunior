package javarush.shop.dao.client_dao;

import javarush.shop.model.Client;
import javarush.shop.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface ClientDAO {
    void saveClient(Client client);

    Client getClientByName(String name);

    void updateBasket(Long id, Long productId, int productCount);

    Long getClientId(String name);

    Product getProductFromBasket(Long clientId, Long productId);

    void deleteProductFromBasket(Long clientId, Long productId);

    Integer getProductSufficientFromBasket(Long clientId, Long productId);

    void updateProductCountInBasket(Long clientId, Long productId, int productCount);

    Map<Product, Integer> getProductSFromBasket(Long clientId);

    BigDecimal getBalance(Long clientId);

    void substractBalance(Long clientId, BigDecimal totalPrice);

    void addBalance(Long clientId, BigDecimal refundAmount);
}
