package javarush.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Shop {
    private List<Cashier> cashiers;
    private Warehouse warehouse;
    private double bank;

    public Shop() {
        cashiers = new ArrayList<>();
        warehouse = new Warehouse();
    }

    public Set<String> getProductsType() {
        return warehouse.getProductTypes();
    }

    public Map<String, List<Product>> getProductsByType() {
        return warehouse.getProductsByType();
    }


    public void transferItemToClient(Cashier cashier, Product product, int count) {
        if (hasProduct(product) && canSellProduct(cashier, product)) {
            double sum = cashier.calculateTotalPrice(product, count);
            setBank(getBank() + sum);
        }
    }

    public void returnProductFromClient(Cashier cashier, Product product, int count) {
        if (hasProduct(product) && canSellProduct(cashier, product)) {
            double sum = cashier.calculateTotalPrice(product, count);
            setBank(getBank() - sum);
        }
    }

    private boolean canSellProduct(Cashier cashier, Product product) {
        return cashier.getProductTypes().contains(product.getName());
    }

    public Cashier getCashierByProductType(String productType) {
        for (Cashier cashier : cashiers) {
            if (cashier.getProductTypes().contains(productType)) {
                return cashier;
            }
        }
        return null;
    }

    public Map<Product, Integer> getProducts() {
        return warehouse.getProductMap();
    }

    public Map.Entry<Product, Integer> getProductEntryByName(String name, Map<Product, Integer> basket) {
        for (Map.Entry<Product, Integer> entry : basket.entrySet()) {
            if (entry.getKey().getName().equalsIgnoreCase(name)) {
                return entry;
            }
        }
        return null;
    }

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

    public void addCashier(Cashier cashier) {
        cashiers.add(cashier);
    }
    public List<Cashier> getCashiers() {
        return cashiers;
    }
    public void addProductToWarehouse(Product product, int count) {
        warehouse.addProduct(product, count);
    }

    public void printWarehouse() {
        warehouse.print();
    }

    public boolean hasProduct(Product product) {
        return warehouse.hasProduct(product);
    }

    public double getBank() {
        return bank;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setBank(double bank) {
        this.bank = bank;
    }
}
