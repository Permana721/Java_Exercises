package _04_ECommerce.util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static String input(String info) {
        System.out.print(info + " ");
        String data = scanner.nextLine();
        return data;
    }

    public static double aDouble(String info){
        System.out.println(info + " ");
        double data = scanner.nextDouble();
        scanner.nextLine();
        return data;
    }

    public static int anInt(String info){
        System.out.println(info + " ");
        int data = scanner.nextInt();
        scanner.nextLine();
        return data;
    }
}
