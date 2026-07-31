package _04_ECommerce.service;

import _04_ECommerce.entity.Product;

import java.util.List;

public interface ProductService {
    Product add(Product product);;
    Product selectProduct(String id);
    Product deleteProduct(String id);
    List<Product> findAll();
}