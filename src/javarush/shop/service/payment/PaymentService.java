package javarush.shop.service.payment;

import javarush.shop.model.Product;

public interface PaymentService {

    double calculateTotalPrice(Product product, int count);
}
