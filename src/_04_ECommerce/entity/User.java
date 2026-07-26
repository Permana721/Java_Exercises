package _04_ECommerce.entity;

public class User {
    private static int counter = 0;
    private static final String PREFIX = "USR-";
    private String id;
    private String name;
    private Cart cart;
    private Order order;
    private UserRole userRole;

    public static synchronized String generateId() {
        counter++;
        return PREFIX + counter;
    }

    public User(String name, Cart cart, Order order, UserRole userRole) {
        id = generateId();
        this.name = name;
        this.cart = cart;
        this.order = order;
        this.userRole = userRole;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void getDetailUser(){
        System.out.println("User Id: " + getId());
        System.out.println("User name: " + getName());
        System.out.println("User cart: " + getCart());
        System.out.println("User Order: " + getOrder());
        System.out.println("User Role: " + getUserRole());
        System.out.println("\n");
    }
}