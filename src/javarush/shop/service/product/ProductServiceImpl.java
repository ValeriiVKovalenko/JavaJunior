package javarush.shop.service.product;

import javarush.shop.model.Product;
import javarush.shop.model.ProductDescription;

public class ProductServiceImpl implements ProductService {
   private Product product;
    @Override
    public double getPrice() {
        return product.getPrice();
    }

    @Override
    public void setPrice(double price) {
        product.setPrice(price);
    }

    @Override
    public ProductDescription getProductDescription() {
        return product.getProductDescription();
    }

    @Override
    public String getName() {
        return product.getName();
    }
}
