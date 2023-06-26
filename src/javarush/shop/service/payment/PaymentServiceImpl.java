package javarush.shop.service.payment;

import javarush.shop.model.Product;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public double calculateTotalPrice(Product product, int count) {
        return product.getPrice() * count;
    }
}
