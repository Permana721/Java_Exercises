package _04_ECommerce.repository;

import _04_ECommerce.entity.Product;
import _04_ECommerce.exception.ProductNotFoundException;
import _04_ECommerce.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepositoryImpl implements ProductRepository{
    private final List<Product> products;

    public ProductRepositoryImpl() {
        this.products = new ArrayList<>();
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product findById(String id) {
        for (Product product : products){
            if (product.getId().equals(id)){
                return product;
            } else {
                throw new ProductNotFoundException("Product with Id " + id + " not found!");
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}