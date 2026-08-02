package _04_ECommerce.service;

import _04_ECommerce.entity.Order;
import _04_ECommerce.entity.User;

import java.util.List;
import java.util.Objects;

public class OrderServiceImpl implements OrderService {
    @Override
    public boolean checkout(User user) {
        if (Objects.isNull(user.getCart())){
            return false;
        }
        double total = user.getCart().calculateTotal();
        if (user.getSaldo() >= total) {

        }
        return true;
    }
}
