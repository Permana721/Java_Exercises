package _04_ECommerce.service;

import _04_ECommerce.entity.Cart;

public interface CartService {
    Cart add(Cart cart);
    Cart remove(Cart cart);
}
