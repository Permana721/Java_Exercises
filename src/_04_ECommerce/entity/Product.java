package _04_ECommerce.entity;
import java.util.Locale;

public class Product {
    private static int counter = 0;
    private static final String PREFIX = "PRD-";
    private String id;
    private String name;
    private Category category;
    private double price;
    private int stock;
    private String decimalFormat;

    public static synchronized String generateId(){
        counter++;
        return PREFIX + counter;
    }

    public Product(String name, double price, Category category, int stock) {
        this.id = generateId();
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.decimalFormat = String.format(Locale.US, "%,.0f", price);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String getDecimalFormat() {
        return decimalFormat;
    }

    public int getStock() {
        return stock;
    }

    public void getDetailProduct(){
        System.out.println("Id Product: " + getId());
        System.out.println("Name Product: " + getName());
        System.out.println("Category Product: " + getCategory().displayName);
        System.out.println("Price Product: " + getDecimalFormat());
        System.out.println("Stock Product: " + getStock());
        System.out.println("\n");
    }

    public void increaseStock(int stock){
        this.stock += stock;
    }

    public void decreaseStock(int stock){
        this.stock -= stock;
    }

}
