package javarush.shop.dao.product_dao;

import javarush.shop.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductDAO {

    List<Product> getProducts();

    Product getProductByName(String name);

    Long getProductId(String name);
}
