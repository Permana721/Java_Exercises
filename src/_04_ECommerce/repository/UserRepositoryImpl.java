package _04_ECommerce.repository;

import _04_ECommerce.entity.User;
import _04_ECommerce.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final List<User> users;

    public UserRepositoryImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User findById(String id) {
        for (User user : users){
            if (user.getId().equals(id)){
                return user;
            } else {
                throw new UserNotFoundException("User with Id: " + id + " not found!");
            }
        }
        return null;
    }

    @Override
    public boolean login(String name, String password) {
        for (User user : users){
            if (user.getName().equals(name) && user.getPassword().equals(password)){
                return true;
            } else {
                throw new UserNotFoundException("Wrong Password or Username!");
            }
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
