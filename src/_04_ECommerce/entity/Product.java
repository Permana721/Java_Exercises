package _04_ECommerce.entity;
import java.util.Locale;

public class Product {
    private int counter = 0;
    private String id = "PRD-";
    private String name;
    private Category category;
    private double price;
    private String decimalFormat;

    public synchronized String addId(){
        counter++;
        return this.id + counter;
    }

    public Product(String name, Category category, double price) {
        this.id = addId();
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


    public double getPrice() {
        return price;
    }

    public String getDecimalFormat() {
        return decimalFormat;
    }

    public void getDetailProduct(){
        System.out.println("Id Product: " + getId());
        System.out.println("Name Product: " + getName());
        System.out.println("Category Product: " + getCategory());
        System.out.println("Price Product: " + getDecimalFormat());
    }

}
