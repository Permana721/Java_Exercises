package _04_ECommerce.test;

import _04_ECommerce.entity.Category;
import _04_ECommerce.entity.Product;
import _04_ECommerce.repository.ProductRepository;
import _04_ECommerce.repository.ProductRepositoryImpl;
import _04_ECommerce.service.ProductService;
import _04_ECommerce.service.ProductServiceImpl;

public class TestProduct {
    static void main(String[] args) {
        ProductRepository productRepository = new ProductRepositoryImpl();
        ProductService productService = new ProductServiceImpl(productRepository);


        Product product = new Product("Jam", Category.FURNITURE, 30000);
        Product product2 = new Product("Jam Tangan", Category.ELECTRONIC, 150_000);


        productService.add(product);
        productService.add(product2);
        productService.findAll();
    }
}
