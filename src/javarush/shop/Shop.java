package javarush.shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Cashier> cashiers;
    private Warehouse warehouse;
    private double bank;

    public Shop(double bank) {
        this.bank = bank;
        cashiers = new ArrayList<>();
        warehouse = new Warehouse();
    }


    public void transferItemToClient(Product product, int count, Cashier cashier, Client client) {
        if (hasProduct(product) && cashier.canSellProduct(product)) {
            warehouse.removeProduct(product, count);
        }
    }

    public void returnProductFromClient(Product product, int count, Client client) {
        addProductToWarehouse(product, count);
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
