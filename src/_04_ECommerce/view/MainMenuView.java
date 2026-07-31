package _04_ECommerce.view;

import _04_ECommerce.entity.User;
import _04_ECommerce.entity.UserRole;
import _04_ECommerce.service.ProductService;
import _04_ECommerce.service.UserService;
import _04_ECommerce.util.InputUtil;

public class MainMenuView {
    private UserService userService;
    private ProductService productService;

    public MainMenuView(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
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

        if (nama == null || password == null){
            System.out.println("Nama atau password tidak boleh kosong!");
        } else {
            User newUser = new User(nama, password, userRole);
            userService.createUser(newUser);
        }
    }

    public void loginMenu() {
        System.out.println("LOGIN");
        var nama = InputUtil.input("Masukkan nama anda: ");
        var password = InputUtil.input("Masukkan password anda: ");

        User currentUser = userService.login(nama, password);
        if (currentUser.getUserRole().equals(UserRole.ADMIN)){
            AdminView adminView = new AdminView(productService);
            adminView.showMenu();
        } else {
            CustomerView customerView = new CustomerView();
        }
    }
}
