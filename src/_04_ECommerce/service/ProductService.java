package _04_ECommerce.service;

import _04_ECommerce.entity.Product;

public interface ProductService {
    Product add(Product product);
    Product findById(String id);
}
