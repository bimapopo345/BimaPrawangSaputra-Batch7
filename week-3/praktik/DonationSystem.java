import java.util.Scanner;
import java.time.LocalDate;

public class DonationSystem {
    // Data philanthropy
    static String[] kodePhil = {"A", "B", "C"};
    static String[] namaPhil = {"A Hope Foundation", "Bright Future Fund", "Care & Share Org"};
    
    // Data donasi (simpan maksimal 100 donasi per philanthropy)
    static String[][] namaDonatur = new String[3][100];  // [philanthropy ke-][donasi ke-]
    static double[][] jumlahDonasi = new double[3][100];
    static String[][] tanggalDonasi = new String[3][100];
    static int[] jumlahDataDonasi = {0, 0, 0};  // Jumlah donasi yang sudah masuk per philanthropy
    
    // Scanner untuk input
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            tampilkanMenu();
            System.out.print("Pilih menu (0 untuk keluar): ");
            String pilihan = scanner.nextLine();
            
            switch (pilihan) {
                case "1":
                    prosesDonasiInput();
                    break;
                case "2":
                    tampilkanHistoryDonasi();
                    break;
                case "0":
                    System.out.println("Terima kasih! Program berakhir.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    private static void tampilkanMenu() {
        System.out.println("\n==== CONSOLE DONATION SYSTEM ====");
        System.out.println("Daftar Philanthropy:");
        for (int i = 0; i < kodePhil.length; i++) {
            System.out.printf("[%s] %s%n", kodePhil[i], namaPhil[i]);
        }
        System.out.println("\n1. Donasi");
        System.out.println("2. Lihat History");
        System.out.println("0. Keluar");
    }
    
    private static void prosesDonasiInput() {
        System.out.print("Nama Anda    : ");
        String nama = scanner.nextLine();
        
        System.out.print("Kode Phil.   : ");
        String kode = scanner.nextLine().toUpperCase();
        
        // Cari indeks philanthropy
        int indeksPhil = -1;
        for (int i = 0; i < kodePhil.length; i++) {
            if (kodePhil[i].equals(kode)) {
                indeksPhil = i;
                break;
            }
        }
        
        if (indeksPhil == -1) {
            System.out.println("❌ Kode philanthropy tidak valid!");
            return;
        }
        
        System.out.print("Jumlah Rp    : ");
        double jumlah;
        try {
            jumlah = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Jumlah tidak valid!");
            return;
        }
        
        // Simpan donasi
        int indeksBaru = jumlahDataDonasi[indeksPhil];
        namaDonatur[indeksPhil][indeksBaru] = nama;
        jumlahDonasi[indeksPhil][indeksBaru] = jumlah;
        tanggalDonasi[indeksPhil][indeksBaru] = LocalDate.now().toString();
        jumlahDataDonasi[indeksPhil]++;
        
        // Tampilkan konfirmasi
        System.out.println("✔ Terima kasih, " + nama + "!");
        System.out.printf("Donasi Rp%,.0f ke %s tercatat.%n", 
            jumlah, namaPhil[indeksPhil]);
    }
    
    private static void tampilkanHistoryDonasi() {
        for (int i = 0; i < kodePhil.length; i++) {
            if (jumlahDataDonasi[i] > 0) {
                System.out.printf("%n==== HISTORY DONASI: %s ====%n", namaPhil[i]);
                for (int j = 0; j < jumlahDataDonasi[i]; j++) {
                    System.out.printf("%-3d%-13s%-12s%s%n",
                        j + 1,
                        namaDonatur[i][j],
                        String.format("Rp%,.0f", jumlahDonasi[i][j]),
                        tanggalDonasi[i][j]);
                }
            }
        }
    }
}
