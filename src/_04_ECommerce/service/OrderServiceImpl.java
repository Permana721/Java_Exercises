package _04_ECommerce.service;

import _04_ECommerce.entity.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public String checkout(String customerId) {
        return "";
    }

    @Override
    public Order processNextOrder() {
        return null;
    }

    @Override
    public List<Order> getOrderHistory(String customerId) {
        return List.of();
    }

    @Override
    public List<Order> getAllOrders() {
        return List.of();
    }
}
