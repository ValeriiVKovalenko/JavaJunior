package javarush.shop.service.client;

import javarush.shop.model.Client;
import javarush.shop.model.Product;

import java.util.Map;

public interface ClientService {
    void addItemToBasket(Product product, int count);

    void removeItemFromBasket(Product product, int count);

    void removeItemFromBasket(Product product);

    Map<Product, Integer> getBasket();

    double getBalance();

    void setBalance(double sum);

    void setClient(Client client);
}
