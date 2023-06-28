package javarush.shop.dao.warehouse_dao;

import javarush.shop.database.DatabaseManager;
import javarush.shop.model.Product;
import javarush.shop.model.ProductDescription;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SQLLiteWarehouseDAO implements WarehouseDAO {
    DatabaseManager databaseManager;

    public SQLLiteWarehouseDAO(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    public int getProductCount(String name) {
        int productCount = 0;
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT w.quantity FROM Warehouse w " +
                             "JOIN Products p ON w.product_id = p.id " +
                             "WHERE p.name = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                productCount = resultSet.getInt("quantity");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productCount;
    }

    @Override
    public void updateProductDedictionCount(Long productId, int count) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE Warehouse SET quantity = quantity - ? WHERE product_id = ?")) {
            statement.setInt(1, count);
            statement.setLong(2, productId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateProductAddictionCount(Long productId, int count) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE Warehouse SET quantity = quantity + ? WHERE product_id = ?")) {
            statement.setInt(1, count);
            statement.setLong(2, productId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Map<Product, Integer> getProductsMap() {
        Map<Product, Integer> productsMap = new HashMap<>();
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT p.id, p.name, p.price, w.quantity, d.type " +
                             "FROM products p " +
                             "JOIN warehouse w ON p.id = w.product_id " +
                             "JOIN Descriptions d ON p.description_id = d.id")) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long productId = resultSet.getLong("id");
                String productName = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                int quantity = resultSet.getInt("quantity");
                String productType = resultSet.getString("type");

                ProductDescription productDescription = new ProductDescription(productType);
                Product product = new Product(productId, productName, productDescription, price);
                productsMap.put(product, quantity);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productsMap;
    }
}
