package javarush.shop.model;

import javarush.shop.dao.product_description_dao.ProductDescriptionDAO;
import javarush.shop.dao.product_dao.ProductDAO;
import javarush.shop.dao.warehouse_dao.WarehouseDAO;

import java.util.*;

public class Warehouse {
    ProductDAO productDAO;
    ProductDescriptionDAO productDescriptionDAO;
    WarehouseDAO warehouseDAO;

    public Warehouse(ProductDAO productDAO, ProductDescriptionDAO productDescriptionDAO, WarehouseDAO warehouseDAO) {
        this.productDAO = productDAO;
        this.productDescriptionDAO = productDescriptionDAO;
        this.warehouseDAO = warehouseDAO;
    }

    public List<String> getProductTypes() {
        return productDescriptionDAO.getProductTypes();
    }

    public List<Product> getProductsByType() {
        return productDAO.getProducts();
    }

    public int getProductCount(String name) {
        return warehouseDAO.getProductCount(name);
    }

    public Long getProductId(String name) {
        return productDAO.getProductId(name);
    }

    public void addProduct(Product product, Integer count) {
        warehouseDAO.updateProductAddictionCount(product.getId(), count);
    }

    public boolean hasProduct(Product product) {
        Product productByName = productDAO.getProductByName(product.getName());
        return productByName != null;
    }

    public Product getProduct(String productName) {
        return productDAO.getProductByName(productName);
    }

    public void removeProductCount(Long productId, int count) {
        warehouseDAO.updateProductDedictionCount(productId, count);
    }
}
