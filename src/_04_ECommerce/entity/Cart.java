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
            throw new ProductNotFoundException("Tidak boleh membeli kurang dari 0!");
        }
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().equals(product)){
                cartItem.increaseQuantity(qty);
                return true;
            }
        }
        CartItem newCartItem = new CartItem(product, qty);
        if (product.getStock() < qty){
            System.out.println("Stok hanya tersedia " + product.getStock() + " saja");
        } else {
            cartItems.add(newCartItem);
            return true;
        }
        return false;
    }

    public void removeProduct(String productId) {

    }

    public void clear(){
        cartItems.clear();
    }

    public void calculateTotal(){

    }

    public void isEmpty() {

    }

}
