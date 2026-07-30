package _04_ECommerce.repository;

import _04_ECommerce.entity.User;

import java.util.List;

public interface UserRepository {
    User save(User user);
    User findById(String id);
    boolean login(String name, String password);
    List<User> findAll();
}
