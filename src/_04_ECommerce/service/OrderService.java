package _04_ECommerce.service;

import _04_ECommerce.entity.Order;
import _04_ECommerce.entity.User;

import java.util.List;

public interface OrderService {
    boolean checkout(User user);
}