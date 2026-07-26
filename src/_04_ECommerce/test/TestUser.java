package _04_ECommerce.test;

import _04_ECommerce.entity.User;
import _04_ECommerce.entity.UserRole;
import _04_ECommerce.repository.UserRepository;
import _04_ECommerce.repository.UserRepositoryImpl;
import _04_ECommerce.service.UserService;
import _04_ECommerce.service.UserServiceImpl;

public class TestUser {
    static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserServiceImpl(userRepository);

        User user = new User("Permana", null, null, UserRole.USER);
        User user1 = new User("Arido", null, null, UserRole.ADMIN);

        userService.createUser(user);
        userService.createUser(user1);
        userService.selectAll();
    }
}
