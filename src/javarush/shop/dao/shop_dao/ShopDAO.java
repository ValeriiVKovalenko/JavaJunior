package javarush.shop.dao.shop_dao;


import java.math.BigDecimal;

public interface ShopDAO {
    void addBalance(BigDecimal amount);

    void subtractBalance(BigDecimal refundAmount);
}
