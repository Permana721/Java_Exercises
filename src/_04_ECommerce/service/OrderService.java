package _04_ECommerce.service;

import _04_ECommerce.entity.Order;

import java.util.List;

public interface OrderService {
    String checkout(String customerId);
    Order processNextOrder();
    List<Order> getOrderHistory(String customerId);
    List<Order> getAllOrders();
}
