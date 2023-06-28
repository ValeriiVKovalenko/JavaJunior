package javarush.shop.dao.product_dao;

import javarush.shop.database.DatabaseManager;
import javarush.shop.model.Product;
import javarush.shop.model.ProductDescription;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLLiteProductDAO implements ProductDAO {
    DatabaseManager databaseManager;

    public SQLLiteProductDAO(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(

                     "SELECT p.id, p.name, p.price, d.type " +
                             "FROM Products p " +
                             "JOIN Descriptions d ON p.description_id = d.id ")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                String type = resultSet.getString("type");

                ProductDescription productDescription = new ProductDescription(type);
                Product product = new Product(id, name, productDescription, price);
                products.add(product);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProductByName(String name) {
        Product product = null;
        try (Connection connection = databaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT p.id, p.name, p.price, d.type " +
                        "FROM Products p " +
                        "JOIN Descriptions d ON p.description_id = d.id " +
                        "WHERE p.name = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long productId = resultSet.getLong("id");
                String productName = resultSet.getString("name");
                BigDecimal productPrice = resultSet.getBigDecimal("price");
                String productType = resultSet.getString("type");

                ProductDescription productDescription = new ProductDescription(productType);
                product = new Product(productId, productName, productDescription, productPrice);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }

    @Override
    public Long getProductId(String name) {
        Long id = null;
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT id FROM Products WHERE name = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getLong("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }
}
