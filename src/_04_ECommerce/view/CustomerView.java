package _04_ECommerce.view;

import _04_ECommerce.entity.Cart;
import _04_ECommerce.entity.CartItem;
import _04_ECommerce.entity.Product;
import _04_ECommerce.entity.User;
import _04_ECommerce.service.ProductService;
import _04_ECommerce.service.UserService;
import _04_ECommerce.util.InputUtil;

import java.util.List;

public class CustomerView {
    private final UserService userService;
    private final ProductService productService;
    private final User user;

    public CustomerView(UserService userService, ProductService productService, User user) {
        this.userService = userService;
        this.productService = productService;
        this.user = user;
    }

    public void showMenu(){
        while (true) {
            System.out.println("==================================");
            System.out.println("Customer Menu");
            System.out.println("==================================");
            System.out.println("1. Top Up Saldo");
            System.out.println("2. Lihat informasi akun");
            System.out.println("3. Lihat semua produk");
            System.out.println("4. Lihat keranjang");
            System.out.println("5. Checkout");
            System.out.println("0. Logout");

            String input = InputUtil.input("Pilih: ");

            switch (input){
                case "1" -> topup();
                case "2" -> user.getDetailUser();
                case "3" -> showAllProduct();
                case "4" -> showCart();
                case "5" -> {}
                case "0" -> {
                    return;
                }
                default -> System.out.println("Tolong masukkan input yang valid!");
            }
        }
    }

    public void topup() {
        String amount = InputUtil.input("Masukkan jumlah saldo: ");
        if (amount.isBlank()) {
            System.out.println("Tolong masukan jumlah yang valid!");
        } else {
            userService.topup(user, Double.parseDouble(amount));
            System.out.println("Topup Berhasil! saldo bertambah Rp. " + amount);
        }
    }

    public void showAllProduct() {
        List<Product> products = productService.findAll();
        for (Product product : products) {
            product.getDetailProduct();
        }
        String id = InputUtil.input("Pilih Id produk yang ingin dibeli: ");
        Product selectedProduct = productService.selectProduct(id);
        String qty = InputUtil.input("Masukan jumlah yang ingin dibeli: ");
        boolean success = user.getCart().addProduct(selectedProduct, Integer.parseInt(qty));
        if (success) {
            System.out.println("Produk " + selectedProduct.getName() + " sudah berhasil di tambahkan ke Keranjang!");
        } else {
            System.out.println("Produk gagal ditambahkan");
        }
    }

    public void showCart() {
        List<CartItem> carts = user.getCart().getCartItems();
        if (carts.isEmpty()){
            System.out.println("Keranjang masih kosong!");
        }
        for (CartItem cartItem : carts) {
            cartItem.showCartItem();
        }
    }
}
