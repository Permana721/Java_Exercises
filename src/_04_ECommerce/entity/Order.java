package _04_ECommerce.entity;

public class Order {
    private Cart cart;

    public Order(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
