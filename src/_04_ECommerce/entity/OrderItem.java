package _04_ECommerce.entity;

public class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public void printDetail() {
        System.out.println("=============RINCIAN PEMBELIAN=============");
        System.out.println("Nama: " + product.getName());
        System.out.println("Harga: " + product.getDecimalFormat());
        System.out.println("Qty: " + quantity);
        System.out.println("Subtotal: Rp." + getSubtotal());
        System.out.println("===========================================");
    }
}
