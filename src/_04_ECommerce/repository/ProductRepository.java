package _04_ECommerce.repository;

import _04_ECommerce.entity.Product;

import java.util.List;

public interface ProductRepository {
    Product save(Product product);
    Product findById(String id);
    Product delete(String id);
    List<Product> findAll();
}
