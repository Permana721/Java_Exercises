package _04_ECommerce.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private double total = 0;
    private List<OrderItem> orderItems;

    public Order() {
        this.orderItems = new ArrayList<>();
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public double calculateTotal() {
        for (OrderItem orderItem : orderItems) {
            total += orderItem.getSubtotal();
        }
        return total;
    }

    public void showDetail() {
        for (OrderItem orderItem : orderItems) {
            orderItem.printDetail();
        }
    }
}
