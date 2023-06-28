package javarush.shop.model;

import javarush.shop.service.shop.ShopService;
import javarush.shop.service.shop.ShopServiceImp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Cashier> cashiers;
    private Warehouse warehouse;
    private BigDecimal bank;

    public Shop() {
        cashiers = new ArrayList<>();
    }

    public List<Cashier> getCashiers() {
        return cashiers;
    }

    public BigDecimal getBank() {
        return bank;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setCashiers(List<Cashier> cashiers) {
        this.cashiers = cashiers;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void setBank(BigDecimal bank) {
        this.bank = bank;
    }
}
