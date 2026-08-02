package _04_ECommerce.service;

import _04_ECommerce.entity.User;
import _04_ECommerce.exception.UserAlreadyExistsException;
import _04_ECommerce.exception.UserNotFoundException;
import _04_ECommerce.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository users;

    public UserServiceImpl(UserRepository users) {
        this.users = users;
    }

    @Override
    public User createUser(User user) {
        List<User> exitingUser = users.findAll();

        for (User users : exitingUser) {
            if (users.getName().equalsIgnoreCase(user.getName())) {
                throw new UserAlreadyExistsException("User dengan nama " + user.getName() + " sudah ada!");
            }
        }
        return users.save(user);
    }

    @Override
    public User selectUser(String id) {
        User user = users.findById(id);
        if (user.getId().equals(id)) {
            return user;
        } else {
            throw new UserNotFoundException("User with Id: " + id + " not found!");
        }
    }

    @Override
    public User login(String name, String password) {
        User user = users.login(name, password);
        if (user != null) {
            System.out.println("Berhasil Login!");
            return user;
        }
        return null;
    }

    @Override
    public void topup(User user, double saldo) {
        user.deposit(saldo);
    }

    @Override
    public List<User> selectAll() {
        return users.findAll();
    }
}
