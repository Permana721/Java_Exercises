package _04_ECommerce.entity;

public class User {
    private int counter = 0;
    private String id = "CST-";
    private String name;
    private Cart cart = new Cart();
    private Order order = new Order();

    public User() {

    }

    public User(String name, Cart cart, Order order) {
        this.id = generateId();
        this.name = name;
        this.cart = cart;
        this.order = order;
    }

    public synchronized String generateId() {
        counter++;
        return this.id + counter;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Cart getCart() {
        return cart;
    }

    public Order getOrder() {
        return order;
    }

    public void getDetailUser(){
        System.out.println("User Id: " + getId());
        System.out.println("User name: " + getName());
        System.out.println("User cart: " + getCart());
        System.out.println("User Order: " + getOrder());
    }
}