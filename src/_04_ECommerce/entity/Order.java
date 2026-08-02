package _04_ECommerce.entity;

import java.util.List;

public class Order {
    private Cart cart;
    private List<OrderItem> orderItems;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void addOrderItem() {

    }

    public void calculateTotal() {

    }

    public void getOrderItems(){

    }
}
