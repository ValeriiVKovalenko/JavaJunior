package javarush.shop.service.payment;

import javarush.shop.model.Product;

import java.math.BigDecimal;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public BigDecimal calculateTotalPrice(Product product, int count) {
        return product.getPrice().multiply(BigDecimal.valueOf(count));
    }
}
