package javarush.shop.service.payment;

import javarush.shop.model.Product;

import java.math.BigDecimal;

public interface PaymentService {

    BigDecimal calculateTotalPrice(Product product, int count);
}
