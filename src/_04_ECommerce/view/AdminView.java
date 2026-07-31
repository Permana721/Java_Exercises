package _04_ECommerce.view;

import _04_ECommerce.entity.Category;
import _04_ECommerce.entity.Product;
import _04_ECommerce.entity.User;
import _04_ECommerce.service.ProductService;
import _04_ECommerce.service.UserService;
import _04_ECommerce.util.InputUtil;

public class AdminView {
    private UserService userService;
    private ProductService productService;

    public AdminView() {
    }

    public AdminView(User user) {
        this.userService = userService;
    }

    public void showMenu(){
        while (true) {
            System.out.println("==================================");
            System.out.println("Admin Menu");
            System.out.println("==================================");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Edit Produk");
            System.out.println("3. Hapus Produk");
            System.out.println("4. Lihat semua produk");
            System.out.println("5. Lihat semua user");
            System.out.println("0. Exit");

            String input = InputUtil.input("Pilih: ");

            switch (input){
                case "1" -> addProduct();
                case "2" -> {}
                case "3" -> {}
                case "4" -> {}
                case "5" -> {}
                case "0" -> {
                    return;
                }
            }
        }
    }

    public void addProduct() {
        String name = InputUtil.input("Masukkan nama produk: ");
        double price = InputUtil.aDouble("Masukkan harga produk: ");
        int categoryInput = InputUtil.anInt("Masukkan kategori produk" +
                "\n1. Fashion\n2. Electronic\n3. Healthy \n4. Furniture\n5. Food");
        Category category = null;
        int stock = InputUtil.anInt("Masukkan stok produk: ");

        switch (categoryInput) {
            case 1 -> category = Category.FASHION;
            case 2 -> category = Category.ELECTRONIC;
            case 3 -> category = Category.HEALTHY;
            case 4 -> category = Category.FURNITURE;
            case 5 -> category = Category.FOOD;
            default -> System.out.println("Tolong masukkan input yang valid!");
        }

        Product newProduct = new Product(name, price, category, stock);
        productService.add(newProduct);
    }
}
