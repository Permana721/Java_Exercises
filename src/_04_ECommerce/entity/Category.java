package _04_ECommerce.entity;

public enum Category {
    DRINK("Drink"),
    BEVERAGE("Beverage"),
    FOOD("Food");

    String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }
}
