package javarush.shop.dao.cashier_dao;

import javarush.shop.database.DatabaseManager;
import javarush.shop.model.Cashier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SQLLiteCashierDAO implements CashierDAO {
    DatabaseManager databaseManager;

    public SQLLiteCashierDAO(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    public List<Cashier> getCashiers() {
        List<Cashier> cashiers = new ArrayList<>();
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT c.id, c.name, c.experience, d.type\n" +
                             "FROM Cashiers c\n" +
                             "JOIN Cashier_ProductGroup cp ON c.id = cp.cashier_id\n" +
                             "JOIN Descriptions d ON cp.group_id = d.id")) {
            ResultSet resultSet = statement.executeQuery();

            Map<Long, Set<String>> cashierProductsMap = new HashMap<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int experience = resultSet.getInt("experience");
                String product = resultSet.getString("type");

                Set<String> productsForCashier = cashierProductsMap.getOrDefault(id, new HashSet<>());
                productsForCashier.add(product);
                cashierProductsMap.put(id, productsForCashier);
            }

            for (Map.Entry<Long, Set<String>> entry : cashierProductsMap.entrySet()) {
                long id = entry.getKey();
                String name = resultSet.getString("name");
                int experience = resultSet.getInt("experience");
                Set<String> productsForCashier = entry.getValue();

                Cashier cashier = new Cashier(id, name, experience, productsForCashier);
                cashiers.add(cashier);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cashiers;
    }
}
