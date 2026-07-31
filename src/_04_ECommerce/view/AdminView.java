package _04_ECommerce.view;

import _04_ECommerce.entity.Category;
import _04_ECommerce.entity.Product;
import _04_ECommerce.entity.User;
import _04_ECommerce.exception.ProductNotNullException;
import _04_ECommerce.service.ProductService;
import _04_ECommerce.service.ProductServiceImpl;
import _04_ECommerce.service.UserService;
import _04_ECommerce.util.InputUtil;

import java.util.Objects;

public class AdminView {
    private UserService userService;
    private final ProductService productService;

    public AdminView(ProductService productService) {
        this.productService = productService;
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
                case "2" -> {
                    String id = InputUtil.input("Masukkan ID produk yang ingin di edit: ");
                    Product product = productService.selectProduct(id);
                    if (Objects.isNull(product)){
                        throw new ProductNotNullException("Product cannot set to be NULL!");
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
                case "3" -> {
                    String id = InputUtil.input("Masukan ID produk yang ingin dihapus: ");
                    productService.deleteProduct(id);
                }
                case "4" -> productService.findAll();
                case "5" -> {}
                case "0" -> {
                    return;
                }
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
        productService.add(newProduct);
    }
}
