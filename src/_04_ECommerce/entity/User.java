package _04_ECommerce.entity;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class User {
    private static int counter = 0;
    private static final String PREFIX = "USR-";
    private String id;
    private String name;
    private String password;
    private double saldo;
    private Cart cart;
    private Order order;
    private UserRole userRole;
    private String decimalFormat;

    public static synchronized String generateId() {
        counter++;
        return PREFIX + counter;
    }

    public String generateDecimalFormat(double amount) {
        this.decimalFormat = String.format(Locale.US, "%,.0f", amount);
        return decimalFormat;
    }

    public User(String name, String password, UserRole userRole) {
        id = generateId();
        this.name = name;
        this.password = password;
        this.userRole = userRole;
        this.cart = new Cart();
        this.order = new Order();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cart getCart() {
        return cart;
    }

    public Order getOrder() {
        return order;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getDecimalFormat() {
        return decimalFormat;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void getDetailUser(){
        System.out.println("\n====================================");
        System.out.println("User Id: " + getId());
        System.out.println("User name: " + getName());
        System.out.println("User password: " + getPassword());
        if (decimalFormat == null) {
            System.out.println("User saldo: Rp. 0");
        } else {
            System.out.println("User saldo: " + getDecimalFormat());
        }
        System.out.print("User cart: " );
        getCartItems();
        System.out.print("\nUser Order: ");
        getOrderItems();
        System.out.println("\nUser Role: " + getUserRole());
        System.out.println("====================================\n");
    }

    public void deposit(double saldo) {
        this.saldo += saldo;
        generateDecimalFormat(saldo);
    }

    public void withdraw(double saldo) {
        this.saldo -= saldo;
        generateDecimalFormat(saldo);
    }

    public void getCartItems() {
        List<CartItem> cartItems = getCart().getCartItems();

        if (cartItems.isEmpty()) {
            System.out.println("Anda belum memasukan barang ke dalam keranjang belanja!");
        } else {
            for (CartItem cartItem : cartItems) {
                cartItem.showCartItem();
            }
        }
    }

    public void getOrderItems() {
        List<OrderItem> orderItems = getOrder().getOrderItems();

        if (orderItems.isEmpty()) {
            System.out.println("Anda belum memesan barang apapun!");
        } else {
            for (OrderItem orderItem : orderItems) {
                orderItem.printDetail();
            }
        }
    }
}