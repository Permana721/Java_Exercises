package _04_ECommerce.test;

import _04_ECommerce.entity.User;

public class TestUser {
    static void main(String[] args) {
        User user = new User("Permana", null, null);
        User user1 = new User("Arido", null, null);

        user.getDetailUser();
        user1.getDetailUser();
    }
}
