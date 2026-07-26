package _04_ECommerce.entity;

public enum Category {
    FASHION("Fashion"),
    ELECTRONIC("Electronic"),
    HEALTHY("Healthy"),
    FURNITURE("Furnitre"),
    FOOD("Food");

    String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
