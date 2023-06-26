package javarush.shop.service.shop;

import javarush.shop.model.Warehouse;
import javarush.shop.model.Cashier;
import javarush.shop.model.Product;
import javarush.shop.model.Shop;
import javarush.shop.service.cashier.CashierService;
import javarush.shop.service.cashier.CashierServiceImp;
import javarush.shop.service.payment.PaymentService;
import javarush.shop.service.payment.PaymentServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShopServiceImp implements ShopService {
    private Warehouse warehouse;
    private Shop shop;

    private CashierService cashierService;
    private PaymentService paymentService;

    public ShopServiceImp(Shop shop, Warehouse warehouse) {
        this.shop = shop;
        this.warehouse = warehouse;
        cashierService = new CashierServiceImp();
        paymentService = new PaymentServiceImpl();
    }

    @Override
    public Map<String, List<Product>> getProductsByType() {
        return warehouse.getProductsByType();
    }

    @Override
    public void transferItemToClient(Cashier cashier, Product product, int count) {
        if (hasProduct(product) && canSellProduct(cashier, product)) {
            double sum = paymentService.calculateTotalPrice(product, count);
            setBank(getBank() + sum);
        }
    }

    @Override
    public void returnProductFromClient(Cashier cashier, Product product, int count) {
        if (hasProduct(product) && canSellProduct(cashier, product)) {
            double sum = paymentService.calculateTotalPrice(product, count);
            setBank(getBank() - sum);
        }
    }

    @Override
    public boolean canSellProduct(Cashier cashier, Product product) {
        return cashierService.getProductTypes().contains(product.getName());
    }

    @Override
    public Cashier getCashierByProductType(String productType) {
        for (Cashier cashier : shop.getCashiers()) {
            if (cashierService.getProductTypes().contains(productType)) {
                return cashier;
            }
        }
        return null;
    }

    @Override
    public Map<Product, Integer> getProducts() {
        return warehouse.getProductMap();
    }

    @Override
    public Map.Entry<Product, Integer> getProductEntryByName(String name, Map<Product, Integer> basket) {
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            if (entry.getKey().getName().equalsIgnoreCase(name)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public Map.Entry<Product, Integer> getProductEntryByName(String name) {
        Map<Product, Integer> productMap = warehouse.getProductMap();
        Set<Map.Entry<Product, Integer>> entries = productMap.entrySet();
        for (Map.Entry<Product, Integer> entry : entries) {
            if (entry.getKey().getName().equalsIgnoreCase(name)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public List<Cashier> getCashiers() {
        return shop.getCashiers();
    }

    @Override
    public boolean hasProduct(Product product) {
        return warehouse.hasProduct(product);
    }

    @Override
    public double getBank() {
        return shop.getBank();
    }

    @Override
    public Warehouse getWarehouse() {
        return warehouse;
    }

    @Override
    public void setBank(double bank) {
        shop.setBank(bank);
    }

    @Override
    public boolean hasProductName(String name) {
        return warehouse.hasProduct(name);
    }

}