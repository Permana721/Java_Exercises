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

public class TestUser {
    static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);

        User user = new User("Permana", "123" ,UserRole.USER);
        User user1 = new User("Arido", "333" ,UserRole.ADMIN);


        userService.createUser(user);
        userService.createUser(user1);
        userService.selectAll();
        System.out.println(userService.login("Permana", "123"));
    }
}
