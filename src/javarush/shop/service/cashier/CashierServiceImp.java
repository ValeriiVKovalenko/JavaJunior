package javarush.shop.service.cashier;

import javarush.shop.dao.cashier_dao.CashierDAO;
import javarush.shop.model.Cashier;

import java.util.List;

public class CashierServiceImp implements CashierService {
    private final CashierDAO cashierDAO;

    public CashierServiceImp(CashierDAO cashierDAO) {
        this.cashierDAO = cashierDAO;
    }

    @Override
    public List<Cashier> getCashiers() {
        return cashierDAO.getCashiers();
    }
}
