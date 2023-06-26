package javarush.shop.service.product;

import javarush.shop.model.ProductDescription;

public interface ProductService {
    double getPrice();

    void setPrice(double price);

    ProductDescription getProductDescription();

    String getName();
}
