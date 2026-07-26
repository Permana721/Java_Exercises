package _04_ECommerce.service;

import _04_ECommerce.entity.User;
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
    public List<User> selectAll() {
        List<User> users1 = users.findAll();

        for (User user : users1){
            user.getDetailUser();
        }
        return null;
    }
}
