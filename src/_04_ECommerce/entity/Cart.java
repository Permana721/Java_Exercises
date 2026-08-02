package _04_ECommerce.entity;

import _04_ECommerce.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public boolean addProduct(Product product, int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("Jumlah pembelian harus lebih dari 0!");
        }
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().equals(product)){
                int totalQuantity = qty + cartItem.getQuantity();
                if (product.getStock() < totalQuantity){
                    return false;
                }
                cartItem.increaseQuantity(qty);
                return true;
            }
        }
        if (product.getStock() < qty){
            return false;
        } else {
            CartItem newCartItem = new CartItem(product, qty);
            cartItems.add(newCartItem);
            return true;
        }
    }

    public void removeProduct(String productId) {

    }

    public void clear(){
        cartItems.clear();
    }

    public double calculateTotal(){
        double total = 0;
        for (CartItem cartItem : cartItems){
            total += cartItem.getSubtotal();
        }
        return total;
    }
}
