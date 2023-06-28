package javarush.shop.service.client;

import javarush.shop.dao.client_dao.ClientDAO;
import javarush.shop.model.Client;
import javarush.shop.model.Product;

import java.math.BigDecimal;
import java.util.Map;

public class ClientServiceImpl implements ClientService {
    private final ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public void saveClient(String name, BigDecimal balance) {
        Client currentClient = new Client(name, balance);
        clientDAO.saveClient(currentClient);
    }

    @Override
    public boolean isClientExist(String clientName) {
        Client clientByName = clientDAO.getClientByName(clientName);

        return clientByName != null;
    }

    @Override
    public Client getClientByName(String name) {
        return clientDAO.getClientByName(name);
    }


    @Override
    public void addItemToBasket(String clientName, Long productId, int count) {
        Long clientId = clientDAO.getClientId(clientName);
        clientDAO.updateBasket(clientId, productId, count);
    }

    @Override
    public boolean isProductInBasketExist(String clientName, Long productId) {
        Long clientId = clientDAO.getClientId(clientName);
        Product productFromBasket = clientDAO.getProductFromBasket(clientId, productId);
        return productFromBasket != null;
    }

    public Long getClientId(String name) {
        return clientDAO.getClientId(name);
    }

    @Override
    public boolean isProductSufficientInBasketExist(String clientName, Long productId, int selectedCount) {
        Long clientId = clientDAO.getClientId(clientName);
        Integer productSufficientFromBasket = clientDAO.getProductSufficientFromBasket(clientId, productId);

        return selectedCount > productSufficientFromBasket && selectedCount < 1;
    }

    @Override
    public void subtractBalance(String clientName, BigDecimal totalPrice) {
        Long clientId = clientDAO.getClientId(clientName);
        clientDAO.substractBalance(clientId, totalPrice);
    }

    @Override
    public void addBalance(String clientName, BigDecimal refundAmount) {
        Long clientId = clientDAO.getClientId(clientName);
        clientDAO.addBalance(clientId, refundAmount);
    }

    @Override
    public void removeItemFromBasket(String clientName, Long productId) {
        Long clientId = clientDAO.getClientId(clientName);

        clientDAO.deleteProductFromBasket(clientId, productId);
    }

    @Override
    public void removeItemFromBasket(String clientName, Long productId, int productCount) {
        Long clientId = clientDAO.getClientId(clientName);
        clientDAO.updateProductCountInBasket(clientId, productId, productCount);
    }

    @Override
    public Map<Product, Integer> getBasket(String clientName) {
        Long clientId = clientDAO.getClientId(clientName);
        return clientDAO.getProductSFromBasket(clientId);
    }

    @Override
    public BigDecimal getBalance(String clientName) {
        Long clientId = clientDAO.getClientId(clientName);
        return clientDAO.getBalance(clientId);
    }
}
