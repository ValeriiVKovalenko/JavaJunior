package javarush.shop.dao.warehouse_dao;

import javarush.shop.model.Product;

import java.util.Map;

public interface WarehouseDAO {

    int getProductCount(String name);

    void updateProductDedictionCount(Long productId, int count);

    void updateProductAddictionCount(Long productId, int count);

    Map<Product, Integer> getProductsMap();
}
