package _04_ECommerce.entity;

import java.util.Locale;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity(int quantity) {
        if (product.getStock() < quantity) {
            System.out.println("Stok produk habis! hanya dapat membeli " + (product.getStock() - quantity) + " saja");
        } else {
            this.quantity += quantity;
        }
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public void showCartItem() {
        Double totalPrice = product.getPrice() * quantity;
        String decimalFormat = String.format(Locale.US, "%,.0f", totalPrice);
        System.out.println("\n================KERANJANG BELANJA=======================");
        System.out.println("Id Product: " + product.getId());
        System.out.println("Name Product: " + product.getName());
        System.out.println("Category Product: " + product.getCategory().displayName);
        System.out.println("Total Price Product: " + decimalFormat);
        System.out.println("Quantity Product: " + quantity);
        System.out.println("===========================================================");
    }
}