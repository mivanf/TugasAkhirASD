import java.util.LinkedList;
import java.util.Scanner;

class Mahasiswa {
    String nama;
    int nilai;

    Mahasiswa(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }
}

public class Sorting {

    public static void main(String[] args) {
        LinkedList<Mahasiswa> ll = new LinkedList<>();
        Scanner input = new Scanner(System.in);

        ll.add(new Mahasiswa("Maria", 86));
        ll.add(new Mahasiswa("Putri", 86));
        ll.add(new Mahasiswa("Ayu", 90));
        ll.add(new Mahasiswa("Samuel", 94));
        ll.add(new Mahasiswa("Jonathan", 82));
        ll.add(new Mahasiswa("Kevin", 88));
        ll.add(new Mahasiswa("Clara", 80));
        ll.add(new Mahasiswa("Rina", 90));
        ll.add(new Mahasiswa("Budi", 96));
        ll.add(new Mahasiswa("Devina", 84));

        boolean start = true;
        clearScreen();

        while (start) {
            System.out.println();
            System.out.println("========================");
            System.out.println("|      Menu Utama      |");
            System.out.println("========================");
            System.out.println("1. Tampilkan Semua Data");
            System.out.println("2. Tambah Data Baru");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda: ");
            int menu = input.nextInt();

            switch (menu) {
                case 1:
                    display(ll);
                    break;
                case 2:
                    add(ll, input);
                    break;
                case 3:
                    sort(ll, input);
                    break;
                case 4:
                    clearScreen();
                    start = false;
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        input.close();
    }

    static void add(LinkedList<Mahasiswa> ll, Scanner input) {
        clearScreen();
        System.out.println("========================");
        System.out.println("|   Tambah Data Baru   |");
        System.out.println("========================");
        System.out.print("Nama: ");
        String nama = input.next();
        System.out.print("Nilai: ");
        int nilai = input.nextInt();
        ll.add(new Mahasiswa(nama, nilai));
        clearScreen();
        System.out.println("Data berhasil ditambahkan!");
        
    }

    static void sort(LinkedList<Mahasiswa> ll, Scanner input) {
        clearScreen();
        System.out.println("=========================");
        System.out.println("|    Pengurutan Data    |");
        System.out.println("=========================");
        System.out.println("Urutkan berdasarkan:");
        System.out.println("1. Nama");
        System.out.println("2. Nilai");
        System.out.print("Pilihan Anda: ");
        int sortBy = input.nextInt();

        System.out.println("\nPilih metode sorting:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.print("Pilihan Anda: ");
        int sortMethod = input.nextInt();

        System.out.println("\nUrutkan secara:");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        System.out.print("Pilihan Anda: ");
        int order = input.nextInt();

        boolean orderMethod = (order == 1);

        if (sortMethod == 1) {
            bubbleSort(ll, sortBy, orderMethod);
        } else if (sortMethod == 2) {
            insertionSort(ll, sortBy, orderMethod);
        } else {
            System.out.println("Metode sorting tidak valid!");
            return;
        }

        System.out.println("Data berhasil diurutkan!");
        display(ll);
    }

    static void bubbleSort(LinkedList<Mahasiswa> ll, int sortBy, boolean orderMethod) {
        int n = ll.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                boolean condition;
                if (sortBy == 1) {
                    condition = orderMethod
                            ? ll.get(j).nama.compareTo(ll.get(j + 1).nama) > 0
                            : ll.get(j).nama.compareTo(ll.get(j + 1).nama) < 0;
                } else {
                    condition = orderMethod
                            ? ll.get(j).nilai > ll.get(j + 1).nilai
                            : ll.get(j).nilai < ll.get(j + 1).nilai;
                }

                if (condition) {
                    Mahasiswa temp = ll.get(j);
                    ll.set(j, ll.get(j + 1));
                    ll.set(j + 1, temp);
                }
            }
        }
    }

    static void insertionSort(LinkedList<Mahasiswa> ll, int sortBy, boolean orderMethod) {
        int n = ll.size();
        for (int i = 1; i < n; i++) {
            Mahasiswa key = ll.get(i);
            int j = i - 1;

            while (j >= 0) {
                boolean condition;
                if (sortBy == 1) {
                    condition = orderMethod
                            ? ll.get(j).nama.compareTo(key.nama) > 0
                            : ll.get(j).nama.compareTo(key.nama) < 0;
                } else {
                    condition = orderMethod
                            ? ll.get(j).nilai > key.nilai
                            : ll.get(j).nilai < key.nilai;
                }

                if (!condition) break;

                ll.set(j + 1, ll.get(j));
                j--;
            }
            ll.set(j + 1, key);
        }
    }

    static void display(LinkedList<Mahasiswa> ll) {
        clearScreen();
        System.out.println("====================================");
        System.out.println("|          Data Mahasiswa          |");
        System.out.println("====================================");
        System.out.printf("%-20s | %-6s\n", "Nama", "Nilai");
        System.out.println("----------------------------");
    
        for (Mahasiswa mahasiswa : ll) {
            System.out.printf("%-20s | %-6d\n", mahasiswa.nama, mahasiswa.nilai);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
}