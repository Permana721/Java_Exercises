package _04_ECommerce.service;

import _04_ECommerce.entity.Product;
import _04_ECommerce.exception.ProductNotFoundException;
import _04_ECommerce.repository.ProductRepository;

import java.util.List;
import java.util.Objects;

public class ProductServiceImpl implements ProductService {
    private ProductRepository products;

    public ProductServiceImpl(ProductRepository products) {
        this.products = products;
    }

    @Override
    public Product add(Product product) {
        return products.save(product);
    }

    @Override
    public Product selectProduct(String id) {
        Product product = products.findById(id);
        if (Objects.isNull(product)){
            throw new ProductNotFoundException("User with id " + id + " not found!");
        } else {
            return product;
        }
    }

    @Override
    public Product deleteProduct(String id) {
        if (Objects.isNull(id)){
            throw new ProductNotFoundException("User with id " + id + " not found!");
        } else {
            return products.delete(id);
        }
    }

    @Override
    public List<Product> findAll() {
        return products.findAll();
    }
}