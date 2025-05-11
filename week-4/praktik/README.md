# 📱 API Pengeluaran Sederhana

Program API sederhana untuk mencatat pengeluaran. Dibuat pake Spring Boot!

## 🚀 Cara Jalanin Program

1. **Buka project di IDE**

   - Buka folder `week-4/praktik/demo` di IDE
   - Pastikan Maven sudah kedownload semua dependency

2. **Jalanin Programnya**
   - Cari file `DemoApplication.java`
   - Klik kanan > Run
   - Tunggu sampai muncul tulisan "Started DemoApplication"
   - Server jalan di `http://localhost:8080`

## 📝 Testing di Postman

### 1. Liat Semua Pengeluaran (GET)

- Method: `GET`
- URL: `http://localhost:8080/expenses`
- Response contoh:

```json
[
  {
    "name": "Makan Siang",
    "amount": 25000
  },
  {
    "name": "Transport",
    "amount": 15000
  }
]
```

### 2. Tambah Pengeluaran Baru (POST)

- Method: `POST`
- URL: `http://localhost:8080/expenses`
- Headers:
  ```
  Content-Type: application/json
  ```
- Body:

```json
{
  "name": "Makan Siang",
  "amount": 25000
}
```

- Response 201 (Created) kalau nama baru:

```json
{
  "name": "Makan Siang",
  "amount": 25000
}
```

- Response 200 (OK) kalau nama sudah ada:

```json
{
  "name": "Makan Siang",
  "amount": 50000 // amount lama + amount baru
}
```

## 💡 Cara Kerja Program

1. **Simpan Data**

   - Data disimpan di memory pake ArrayList
   - Data hilang kalau server di-restart
   - Gak pake database biar simple

2. **POST /expenses**

   - Cek dulu nama pengeluarannya
   - Kalau nama baru = tambah ke list
   - Kalau nama sudah ada = jumlahkan amount nya

3. **GET /expenses**
   - Tampilkan semua isi list pengeluaran
   - Format JSON array

## 🔍 Contoh Penggunaan

1. **Tambah pengeluaran baru:**

```bash
curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"Makan Siang\",\"amount\":25000}" http://localhost:8080/expenses
```

2. **Tambah lagi dengan nama sama:**

```bash
curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"Makan Siang\",\"amount\":15000}" http://localhost:8080/expenses
```

3. **Lihat semua pengeluaran:**

```bash
curl http://localhost:8080/expenses
```

## ⚠️ Catatan

- Program ini cuma buat belajar API
- Data hilang kalau server di-restart
- Error handling masih basic
- Belum ada validasi input

Selamat mencoba! 🎉
