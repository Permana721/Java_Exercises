package _02_Todolist_JavaDasar;

import _01_Mahasiswa.exception.InvalidDataException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Todolist> daftarTugas = new ArrayList<>();

        boolean loop = true;
        while (loop) {
            System.out.println("TODOLIST");
            for (int i = 0; i < daftarTugas.size(); i++) {
                System.out.println((i + 1) + ". " + daftarTugas.get(i).getJudul());
            }

            System.out.println("MENU :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int chose = 0;

            try {
                chose = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e){
                throw new InvalidDataException("An error occurred: " + e.getMessage());
            }

            switch (chose) {
                case 1 -> {
                    System.out.println("\nMENAMBAH TODOLIST");
                    System.out.print("Todo (0 jika batal): ");
                    String judul = scanner.nextLine();

                    if ("0".equals(judul)) {
                        System.out.println("Batal menambahkan todolist\n");
                    } else {
                        daftarTugas.add(new Todolist(judul));
                        System.out.println("Berhasil menambahkan todolist!\n");
                    }
                }
                case 2 -> {
                    System.out.println("\nMENGHAPUS TODOLIST");
                    System.out.print("Nomor yang dihapus (0 jika batal): ");
                    int nomor = scanner.nextInt();
                    scanner.nextLine();

                    if (nomor == 0) {
                        System.out.println("Batal menghapus todolist\n");
                    } else {
                        int index = nomor - 1;
                        if (index >= 0 && index < daftarTugas.size()) {
                            daftarTugas.remove(index);
                            System.out.println("Berhasil menghapus todolist!\n");
                        } else {
                            System.out.println("Gagal menghapus! Nomor todolist tidak ditemukan.\n");
                        }
                    }
                }
                case 0 -> {
                    System.out.println("Keluar....");
                    loop = false;
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }
}