# 🎁 Program Donasi Sederhana

Halo teman-teman! Ini adalah program donasi sederhana yang dibuat pake Java. Kamu bisa:

1. Input donasi ke beberapa yayasan
2. Lihat daftar donasi yang udah masuk

## 🚀 Cara Jalanin Program di VSCode

⚠️ **PENTING**: Program ini gak bisa dijalanin pake tombol Run Code di VSCode!

Ikuti langkah ini ya:

1. **Buka Terminal VSCode**

   - Klik menu `Terminal` di atas
   - Pilih `New Terminal`
   - Pastikan terminalnya udah di folder yang bener (ada tulisan `PS E:\DevLand-Digtalent\Tugas\week-3\praktik>`)
   - Kalo belum, ketik: `cd week-3/praktik`

2. **Compile Program**

   ```bash
   javac DonationSystem.java
   ```

   > Note: Bakal muncul warning "deprecated API", tapi gapapa! Program tetep bisa jalan kok 😊

3. **Jalanin Program**

   ```bash
   java DonationSystem
   ```

   ```javascript
   cd week-3/praktik && javac DonationSystem.java && java DonationSystem
   ```

````


## 📱 Cara Pake Program

1. Nanti akan muncul pilihan menu:

   - Ketik `1` kalo mau donasi
   - Ketik `2` kalo mau lihat daftar donasi
   - Ketik `0` kalo mau keluar

2. Kalo pilih donasi:
   - Masukin nama kamu
   - Pilih yayasan (A/B/C)
   - Masukin jumlah donasi

## 🔄 Alur Program

```mermaid
flowchart TD
    A[Mulai] --> B[Tampilkan Menu]
    B --> C{Pilih Menu}
    C -->|1| D[Input Donasi]
    C -->|2| E[Lihat History]
    C -->|0| F[Selesai]

    D --> G[Masukkan Nama]
    G --> H[Pilih Yayasan]
    H --> I[Masukkan Jumlah]
    I --> J[Simpan & Tampilkan Konfirmasi]
    J --> B

    E --> K[Tampilkan Daftar Donasi]
    K --> B
````

## 💾 Cara Program Nyimpan Data

Program ini nyimpen data pake array sederhana:

- Daftar nama yang donasi
- Jumlah donasi dari tiap orang
- Tanggal donasi

Data ini cuma kesimpan selama program jalan aja ya!

## 💡 Tips Pake Program

1. **Di Terminal VSCode:**

   - Pastikan path-nya udah bener (ada tulisan `praktik>` di akhir)
   - Warning pas compile bisa diabaikan
   - Kalo error "command not found", pastikan Java udah keinstall

2. **Waktu Input:**

   - Pilih kode yang bener (A/B/C)
   - Masukin angka aja buat jumlah donasi
   - Gak usah pake Rp atau titik

3. **Kalo Error:**

   - Cek kode yayasan udah bener belum
   - Cek jumlah donasi udah bener belum (angka doang)
   - Coba jalanin ulang programnya

4. **Cara Keluar Program:**
   - Pilih menu 0
   - Atau pencet Ctrl+C

Selamat mencoba! 🎉
