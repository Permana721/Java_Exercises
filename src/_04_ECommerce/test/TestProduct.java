package _04_ECommerce.test;

import _04_ECommerce.entity.*;
import _04_ECommerce.repository.ProductRepository;
import _04_ECommerce.repository.ProductRepositoryImpl;
import _04_ECommerce.repository.UserRepository;
import _04_ECommerce.repository.UserRepositoryImpl;
import _04_ECommerce.service.ProductService;
import _04_ECommerce.service.ProductServiceImpl;
import _04_ECommerce.service.UserService;
import _04_ECommerce.service.UserServiceImpl;

import java.util.List;

public class TestProduct {
    static void main(String[] args) {
        Product product = new Product("Apel", 5_000, Category.FOOD, 2);
        Product product1 = new Product("Mangga", 10_000, Category.FOOD, 2);

        ProductRepository productRepository = new ProductRepositoryImpl();
        ProductService productService = new ProductServiceImpl(productRepository);
        productService.add(product);
        productService.add(product1);
//        List<Product> products = productService.findAll();
//        for (Product showProduct : products){
//            showProduct.getDetailProduct();
//        }

        User userAdmin = new User("Permana", "123", UserRole.ADMIN);
        User userUser = new User("Arido", "123", UserRole.USER);

        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);
        userService.createUser(userAdmin);
        userService.createUser(userUser);
        User currentUser = userService.login("Arido", "123");
        userService.topup(currentUser, 50_000);
        Product selectedProduct = productService.selectProduct("PRD-1");
        currentUser.getCart().addProduct(selectedProduct, 1);
        currentUser.getCart().addProduct(selectedProduct, 2);
        List<CartItem> carts = currentUser.getCart().getCartItems();
        if (carts.isEmpty()){
            System.out.println("Keranjang masih kosong!");
        }
        for (CartItem cartItem : carts) {
            cartItem.showCartItem();
        }
    }
}
