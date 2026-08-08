package _04_ECommerce.service;

import _04_ECommerce.entity.CartItem;
import _04_ECommerce.entity.Order;
import _04_ECommerce.entity.OrderItem;
import _04_ECommerce.entity.User;
import _04_ECommerce.exception.PaymentFailedException;
import _04_ECommerce.exception.ProductNotFoundException;

import java.util.List;
import java.util.Objects;

public class OrderServiceImpl implements OrderService {
    @Override
    public void checkout(User user) {
        List<CartItem> cartItems = user.getCart().getCartItems();
        if (user.getCart().getCartItems().isEmpty()){
            throw new ProductNotFoundException("Anda tidak memiliki barang belanja di dalam keranjang anda!");
        }
        double total = user.getCart().calculateTotal();
        if (user.getSaldo() >= total) {
            for (CartItem cartItem : cartItems) {
                if (cartItem.getProduct().getStock() < cartItem.getQuantity()) {
                    throw new PaymentFailedException("Stok tidak cukup!");
                }
            }
            Order order = new Order();
            for (CartItem cartItem : cartItems) {
                OrderItem orderItem = new OrderItem(cartItem.getProduct(), cartItem.getQuantity());

                order.addOrderItem(orderItem);
                orderItem.getProduct().decreaseStock(cartItem.getQuantity());
            }
            System.out.print("Sudah berhasil membeli: ");
            for (CartItem cartItem : cartItems) {
                cartItem.showCartItem();
            }
            user.withdraw(total);
            user.getCart().clear();
            System.out.print("Sekarang saldo anda telah berkurang menjadi Rp. " + user.generateDecimalFormat(user.getSaldo()) + "\n");
        } else {
            throw new PaymentFailedException("Saldo anda tidak cukup!");
        }
    }
}
