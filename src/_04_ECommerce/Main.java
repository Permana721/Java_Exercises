package _04_ECommerce;

import _04_ECommerce.repository.ProductRepositoryImpl;
import _04_ECommerce.repository.UserRepository;
import _04_ECommerce.repository.UserRepositoryImpl;
import _04_ECommerce.service.*;
import _04_ECommerce.view.MainMenuView;

public class Main {
    static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);
        OrderService orderService = new OrderServiceImpl();
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        ProductServiceImpl productService = new ProductServiceImpl(productRepository);
        MainMenuView mainMenuView = new MainMenuView(userService, productService, orderService);

        mainMenuView.showMainMenu();
    }
}
