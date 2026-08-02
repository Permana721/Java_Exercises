package _04_ECommerce.view;

import _04_ECommerce.entity.User;
import _04_ECommerce.entity.UserRole;
import _04_ECommerce.exception.UserAlreadyExistsException;
import _04_ECommerce.service.OrderService;
import _04_ECommerce.service.ProductService;
import _04_ECommerce.service.UserService;
import _04_ECommerce.util.InputUtil;

public class MainMenuView {
    private UserService userService;
    private ProductService productService;
    private OrderService orderService;

    public MainMenuView(UserService userService, ProductService productService, OrderService orderService) {
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
    }

    public void showMainMenu(){
        while (true) {
            System.out.println("==================================");
            System.out.println("E-Commerce");
            System.out.println("==================================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");

            String input = InputUtil.input("Pilih: ");

            switch (input){
                case "1"-> registerMenu();
                case "2" -> loginMenu();
                case "0" -> {
                    return;
                }
                default -> System.out.println("Tolong masukkan input yang valid!");
            }
        }
    }

    public void registerMenu(){
        System.out.println("REGISTER");
        var nama = InputUtil.input("Masukkan nama anda: ");
        var password = InputUtil.input("Masukkan password anda: ");
        var role = InputUtil.input("Masukkan role anda \n1. Admin\n2. User \nPilih: ");
        UserRole userRole = null;

        switch (role) {
            case "1" -> userRole = UserRole.ADMIN;
            case "2" -> userRole = UserRole.USER;
            default -> System.out.println("Tolong masukan input yang valid!");
        }

        if (nama.isBlank() || password.isBlank()){
            System.out.println("Nama atau password tidak boleh kosong!");
        } else {
            try {
                User newUser = new User(nama, password, userRole);
                userService.createUser(newUser);
                System.out.println("User dengan nama: " + newUser.getName() + " Berhasil dibuat!");
            } catch (UserAlreadyExistsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void loginMenu() {
        System.out.println("LOGIN");
        var nama = InputUtil.input("Masukkan nama anda: ");
        var password = InputUtil.input("Masukkan password anda: ");

        if (nama.isBlank() || password.isBlank()){
            System.out.println("Nama atau password tidak boleh kosong!");
        } else {
            User currentUser = userService.login(nama, password);
            if (currentUser.getUserRole().equals(UserRole.ADMIN)){
                AdminView adminView = new AdminView(productService, userService);
                adminView.showMenu();
            } else {
                CustomerView customerView = new CustomerView(userService, productService, orderService, currentUser);
                customerView.showMenu();
            }
        }
    }
}
