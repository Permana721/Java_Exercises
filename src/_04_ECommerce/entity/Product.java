package _04_ECommerce.entity;
import java.util.Locale;

public class Product {
    private static int counter = 0;
    private static final String PREFIX = "PRD-";
    private String id;
    private String name;
    private Category category;
    private double price;
    private String decimalFormat;

    public static synchronized String generateId(){
        counter++;
        return PREFIX + counter;
    }

    public Product(String name, Category category, double price) {
        this.id = generateId();
        this.name = name;
        this.category = category;
        this.price = price;
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

    public void getDetailProduct(){
        System.out.println("Id Product: " + getId());
        System.out.println("Name Product: " + getName());
        System.out.println("Category Product: " + getCategory().displayName);
        System.out.println("Price Product: " + getDecimalFormat());
        System.out.println("\n");
    }

}
