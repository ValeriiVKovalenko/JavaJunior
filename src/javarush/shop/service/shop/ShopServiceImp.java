package javarush.shop.service.shop;

import javarush.shop.dao.shop_dao.ShopDAO;
import javarush.shop.model.Warehouse;
import javarush.shop.model.Cashier;
import javarush.shop.model.Product;
import javarush.shop.service.cashier.CashierService;
import javarush.shop.service.client.ClientService;
import javarush.shop.service.payment.PaymentService;

import java.math.BigDecimal;
import java.util.*;

public class ShopServiceImp implements ShopService {
    private final Warehouse warehouse;
    private final ShopDAO shopDAO;

    private final CashierService cashierService;
    private final PaymentService paymentService;
    private final ClientService clientService;

    public ShopServiceImp(Warehouse warehouse, PaymentService paymentService,
                          CashierService cashierService, ClientService clientService, ShopDAO shopDAO) {
        this.warehouse = warehouse;
        this.paymentService = paymentService;
        this.cashierService = cashierService;
        this.clientService = clientService;
        this.shopDAO = shopDAO;
    }

    @Override
    public Map<String, List<Product>> getProductsByType() {

        List<Product> productsByType = warehouse.getProductsByType();
        Map<String, List<Product>> products = new HashMap<>();

        for (Product product : productsByType) {
            if (products.containsKey(product.getProductDescription().getType())) {
                products.get(product.getProductDescription().getType()).add(product);
            } else {
                List<Product> productsList = new ArrayList<>();
                productsList.add(product);
                products.put(product.getProductDescription().getType(), productsList);
            }
        }
        return products;
    }

    @Override
    public void transferItemToClient(String clientName, Product product, String productType, int count) {
        Cashier cashierByProductType = getCashierByProductType(productType);

        if (cashierByProductType.getProductTypes().contains(product.getProductDescription().getType())) {
            Long productId = warehouse.getProductId(product.getName());
            clientService.removeItemFromBasket(clientName, productId);

            warehouse.removeProductCount(productId, count);

            BigDecimal totalPrice = getPaymentService().calculateTotalPrice(product, count);

            if (clientService.getBalance(clientName).compareTo(totalPrice) < 0) {
                System.out.println("Insufficient funds in the account. Top off your balance");
                return;
            }

            clientService.subtractBalance(clientName, totalPrice);
            shopDAO.addBalance(totalPrice);
        }
    }

    @Override
    public void returnProductFromClient(String clientName, String productName, int count) {

        Product product = warehouse.getProduct(productName);
        BigDecimal refundAmount = getPaymentService().calculateTotalPrice(product, count);

        if (warehouse.hasProduct(product)) {
            warehouse.addProduct(product, count);
            clientService.addBalance(clientName, refundAmount);
            shopDAO.subtractBalance(refundAmount);
            System.out.printf("%d pcs. %s was successfully returned%n", count, productName);
        } else {
            System.out.println("It was not possible to return the goods. You may have entered the wrong product name");
        }
    }

    @Override
    public Cashier getCashierByProductType(String productType) {
        List<Cashier> cashiers = cashierService.getCashiers();
        for (Cashier cashier : cashiers) {
            if (cashier.getProductTypes().contains(productType)) {
                return cashier;
            }
        }
        return null;
    }

    @Override
    public Warehouse getWarehouse() {
        return warehouse;
    }

    @Override
    public boolean hasProductByName(String name) {
        Product product = warehouse.getProduct(name);
        return product != null;
    }

    @Override
    public boolean hasProductSufficientCount(String name, int count) {
      return warehouse.getProductCount(name) >= count;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }
}