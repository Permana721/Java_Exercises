package _04_ECommerce.view;

import _04_ECommerce.entity.Category;
import _04_ECommerce.entity.Product;
import _04_ECommerce.entity.User;
import _04_ECommerce.exception.ProductNotFoundException;
import _04_ECommerce.service.ProductService;
import _04_ECommerce.service.UserService;
import _04_ECommerce.util.InputUtil;

import java.util.List;
import java.util.Objects;

public class AdminView {
    private final UserService userService;
    private final ProductService productService;

    public AdminView(ProductService productService, UserService userService) {
        this.productService = productService;
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
            System.out.println("0. Logout");

            String input = InputUtil.input("Pilih: ");

            switch (input){
                case "1" -> addProduct();
                case "2" -> editProduct();
                case "3" -> {
                    String id = InputUtil.input("Masukan ID produk yang ingin dihapus: ");
                    productService.deleteProduct(id);
                    System.out.println("Produk dengan ID " + id + " berhasil dihapus!");
                }
                case "4" -> {
                    List<Product> products = productService.findAll();
                    if (products.isEmpty()) {
                        System.out.println("Tidak ada produk!");
                    } else {
                        for (Product product : products) {
                            product.getDetailProduct();
                        }
                    }
                }
                case "5" -> {
                    List<User> users = userService.selectAll();
                    for (User user : users){
                        user.getDetailUser();
                    }
                }
                case "0" -> {
                    return;
                }
                default -> System.out.println("Tolong masukkan input yang valid!");
            }
        }
    }

    public void addProduct() {
        String name = InputUtil.input("Masukkan nama produk: ");
        String price = InputUtil.input("Masukkan harga produk: ");
        String categoryInput = InputUtil.input("Masukkan kategori produk" +
                "\n1. Fashion\n2. Electronic\n3. Healthy \n4. Furniture\n5. Food\nPilih: ");
        Category category = null;
        String stock = InputUtil.input("Masukkan stok produk: ");

        switch (categoryInput) {
            case "1" -> category = Category.FASHION;
            case "2" -> category = Category.ELECTRONIC;
            case "3" -> category = Category.HEALTHY;
            case "4" -> category = Category.FURNITURE;
            case "5" -> category = Category.FOOD;
            default -> System.out.println("Tolong masukkan input yang valid!");
        }

        Product newProduct = new Product(name, Double.parseDouble(price), category, Integer.parseInt(stock));
        Product valid = productService.add(newProduct);
        if (Objects.nonNull(valid)) {
            System.out.println("Berhasil menambahkan product: " + newProduct.getName());
        }
    }

    public void editProduct() {
        String id = InputUtil.input("Masukkan ID produk yang ingin di edit: ");
        Product product = productService.selectProduct(id);
        if (Objects.isNull(product)){
            throw new ProductNotFoundException("Product cannot set to be NULL!");
        }
        product.getDetailProduct();
        String pilihan = InputUtil.input("Bagian apa yang ingin di edit dari produk di atas?\n1. Update nama\n2. Update harga\n 3. Update kategori\n4. Update stok\n0. Kembali\nPilih: ");
        switch (pilihan) {
            case "1" -> {
                String name = InputUtil.input("Masukkan nama baru: ");
                product.setName(name);
            }
            case "2" -> {
                String harga = InputUtil.input("Masukkan harga baru: ");
                product.setPrice(Integer.parseInt(harga));
            }
            case "3" -> {
                String categoryInput = InputUtil.input("Masukkan kategori baru\n1. Fashion\n2. Electronic\n3. Healthy \n4. Furniture\n5. Food\nPilih: ");
                Category category = null;
                switch (categoryInput) {
                    case "1" -> category = Category.FASHION;
                    case "2" -> category = Category.ELECTRONIC;
                    case "3" -> category = Category.HEALTHY;
                    case "4" -> category = Category.FURNITURE;
                    case "5" -> category = Category.FOOD;
                    default -> System.out.println("Tolong masukkan input yang valid!");
                }
                product.setCategory(category);
            }
            case "4" -> {
                String stok = InputUtil.input("Masukkan stok baru: ");
                product.setStock(Integer.parseInt(stok));
            }
            case "0" -> {
                return;
            }
        }
    }
}
