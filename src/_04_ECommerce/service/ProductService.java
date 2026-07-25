package _04_ECommerce.service;

import _04_ECommerce.entity.Product;

public interface ProductServiceImpl {
    Product add(Product product);
    Product findById(String id);
}
