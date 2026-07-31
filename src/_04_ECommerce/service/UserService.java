package _04_ECommerce.service;

import _04_ECommerce.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User selectUser(String id);
    User login(String name, String password);
    void topup(User user, double saldo);
    List<User> selectAll();
}
