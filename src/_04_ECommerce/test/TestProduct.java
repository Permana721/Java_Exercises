package _04_ECommerce.test;

import _04_ECommerce.entity.Category;
import _04_ECommerce.entity.Product;

public class TestProduct {
    static void main(String[] args) {
        Product product = new Product("Jam", Category.BEVERAGE, 30000);

        product.getDetailProduct();
    }
}
