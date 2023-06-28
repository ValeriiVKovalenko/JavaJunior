package javarush.shop.dao.shop_dao;

import javarush.shop.database.DatabaseManager;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLLiteShopDAO implements ShopDAO {
    DatabaseManager databaseManager;

    public SQLLiteShopDAO(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    public void addBalance(BigDecimal amount) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE Shop SET bank = bank + ?")) {
            statement.setBigDecimal(1, amount);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void subtractBalance(BigDecimal refundAmount) {
        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE Shop SET bank = bank - ?")) {
            statement.setBigDecimal(1, refundAmount);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
