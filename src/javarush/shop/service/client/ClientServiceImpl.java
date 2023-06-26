package javarush.shop.service.client;

import javarush.shop.model.Client;
import javarush.shop.model.Product;

import java.util.Map;

public class ClientServiceImpl implements ClientService {
    private Client client;

    @Override
    public void addItemToBasket(Product product, int count) {
        if (client.getBasket().containsKey(product)) {
           client.getBasket().put(product, client.getBasket().get(product) + count);
        } else {
            client.getBasket().put(product, count);
        }
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void removeItemFromBasket(Product product, int count) {
        int currentQuantity = client.getBasket().getOrDefault(product, 0);
        if (currentQuantity > count) {
            client.getBasket().put(product, currentQuantity - count);
        } else {
            client.getBasket().remove(product);
        }
    }

    @Override
    public void removeItemFromBasket(Product product) {
        client.getBasket().remove(product);
    }

    @Override
    public Map<Product, Integer> getBasket() {
        return client.getBasket();
    }

    @Override
    public double getBalance() {
        return client.getBalance();
    }

    @Override
    public void setBalance(double sum) {
        client.setBalance(sum);
    }
}
