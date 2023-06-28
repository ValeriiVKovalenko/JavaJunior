package javarush.shop.dao.client_dao;

import javarush.shop.database.DatabaseManager;
import javarush.shop.model.Client;
import javarush.shop.model.Product;
import javarush.shop.model.ProductDescription;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SQLLiteClientDAO implements ClientDAO {
    private DatabaseManager databaseManager;

    public SQLLiteClientDAO(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    public void saveClient(Client client) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Clients (name, balance) VALUES (?, ?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, client.getName());
            statement.setBigDecimal(2, client.getBalance());

            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);
                    client.setId(id);
                }
            }
            if (!connection.isClosed()) {
            } else {
                System.out.println("Connection to the database is closed.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Client getClientByName(String name) {
        Client client = null;
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM Clients WHERE name = ?")) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                BigDecimal balance = resultSet.getBigDecimal("balance");
                client = new Client(name, balance);
                client.setId(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return client;
    }

    @Override
    public void updateBasket(Long id, Long productId, int productCount) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO Baskets (client_id, product_id, quantity) " +
                             "VALUES (?, ?, ?)")) {
            statement.setLong(1, id);
            statement.setLong(2, productId);
            statement.setInt(3, productCount);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Long getClientId(String name) {
        Long id = null;
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT id FROM Clients WHERE name = ?")) {
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

    @Override
    public Product getProductFromBasket(Long clientId, Long productId) {
        Product product = null;
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT p.id, p.name, p.price, d.type " +
                             "FROM Baskets b " +
                             "JOIN Products p ON b.product_id = p.id " +
                             "JOIN Descriptions d ON p.description_id = d.id " +
                             "WHERE b.client_id = ? AND p.id = ?"
             )) {
            statement.setLong(1, clientId);
            statement.setLong(2, productId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                BigDecimal price = resultSet.getBigDecimal("price");
                String type = resultSet.getString("type");

                ProductDescription productDescription = new ProductDescription(type);
                product = new Product(id, name, productDescription, price);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }

    @Override
    public void deleteProductFromBasket(Long clientId, Long productId) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM Baskets WHERE client_id = ? AND product_id = ?")) {
            statement.setLong(1, clientId);
            statement.setLong(2, productId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Integer getProductSufficientFromBasket(Long clientId, Long productId) {
        int result = 0;
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT quantity FROM Baskets WHERE client_id = ? AND product_id = ?")) {
            statement.setLong(1, clientId);
            statement.setLong(2, productId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getInt("quantity");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public void updateProductCountInBasket(Long clientId, Long productId, int productCount) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE Baskets SET quantity = quantity - ? " +
                             "WHERE client_id = ? AND product_id = ?")) {
            statement.setInt(1, productCount);
            statement.setLong(2, clientId);
            statement.setLong(3, productId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Map<Product, Integer> getProductSFromBasket(Long clientId) {
        Map<Product, Integer> productsMap = new HashMap<>();
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT p.id, p.name, p.price, d.type, b.quantity " +
                             "FROM Baskets b " +
                             "JOIN Products p ON b.product_id = p.id " +
                             "JOIN Descriptions d ON p.description_id = d.id " +
                             "WHERE b.client_id = ?"
             )) {
            statement.setLong(1, clientId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long productId = resultSet.getLong("id");
                String productName = resultSet.getString("name");
                BigDecimal productPrice = resultSet.getBigDecimal("price");
                String productType = resultSet.getString("type");
                int quantity = resultSet.getInt("quantity");

                ProductDescription productDescription = new ProductDescription(productType);
                Product product = new Product(productId, productName, productDescription, productPrice);
                productsMap.put(product, quantity);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productsMap;
    }

    @Override
    public BigDecimal getBalance(Long clientId) {
        BigDecimal balance = null;
        try (Connection connection = databaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(
                "SELECT balance FROM Clients WHERE id = ?")) {
            statement.setLong(1, clientId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                balance = resultSet.getBigDecimal("balance");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return balance;
    }

    @Override
    public void substractBalance(Long clientId, BigDecimal totalPrice) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE Clients SET balance = balance - ? WHERE id = ?")) {
            statement.setBigDecimal(1, totalPrice);
            statement.setLong(2, clientId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void addBalance(Long clientId, BigDecimal refundAmount) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE Clients SET balance = balance + ? WHERE id = ?")) {
            statement.setBigDecimal(1, refundAmount);
            statement.setLong(2, clientId);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}