package _04_ECommerce.entity;

import java.util.List;
import java.util.Locale;

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

    public User(String name, String password, UserRole userRole) {
        id = generateId();
        this.name = name;
        this.password = password;
        this.userRole = userRole;
        this.cart = new Cart();
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
        System.out.println("User saldo: " + getDecimalFormat());
//        System.out.println("User cart: " + getCart());
//        System.out.println("User Order: " + getOrder());
        System.out.println("User Role: " + getUserRole());
        System.out.println("====================================\n");
    }

    public void deposit(double saldo) {
        this.saldo += saldo;
        this.decimalFormat = String.format(Locale.US, "%,.0f", getSaldo());
    }

    public void withdraw(double saldo) {
        this.saldo -= saldo;
        this.decimalFormat = String.format(Locale.US, "%,.0f", getSaldo());
    }

    public boolean isEmpty() {
        if (this.cart == null) {
            return false;
        }
        return true;
    }
}