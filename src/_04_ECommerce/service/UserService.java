package _04_ECommerce.service;

import _04_ECommerce.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User selectUser(String id);
    List<User> selectAll();
}
