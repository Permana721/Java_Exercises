package _04_ECommerce.repository;

import _04_ECommerce.entity.Product;
import _04_ECommerce.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

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
            }
        }
        return null;
    }

    @Override
    public Product delete(String id) {
        Product product = findById(id);
        products.remove(product);
        System.out.println("Produk dengan nama " + product.getName() + " berhasil dihapus!");
        return product;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}