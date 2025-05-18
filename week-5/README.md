# 🎯 Aplikasi Donasi API

Hey guys! Ini adalah aplikasi API untuk mengelola donasi. Gampang banget dipakenya!

## 🚀 Cara Menjalankan Aplikasi

1. Pastikan kamu udah install:

   - Java 17 atau yang lebih baru
   - PostgreSQL
   - Maven

2. Bikin database baru di PostgreSQL:

   ```sql
   CREATE DATABASE donation_db;
   ```

3. Setup username dan password PostgreSQL di `application.properties`:

   ```properties
   spring.datasource.username=postgres     // Ganti sama username kamu
   spring.datasource.password=postgres     // Ganti sama password kamu
   ```

4. Buka terminal, masuk ke folder project:

   ```bash
   cd week-5/praktik/demo
   ```

5. Jalanin aplikasinya:
   ```bash
   mvn spring-boot:run
   ```

## 📝 Cara Pakai API-nya

### 1. Buat Philanthropy Baru

```bash
curl -X POST http://localhost:8080/api/philanthropies \
-H "Content-Type: application/json" \
-d '{
    "name": "Yayasan Peduli Sesama"
}'
```

Response:

```json
{
  "id": 1,
  "name": "Yayasan Peduli Sesama",
  "balance": 0.0
}
```

### 2. Lihat Daftar Philanthropy

```bash
curl http://localhost:8080/api/philanthropies
```

### 3. Kirim Donasi

```bash
curl -X POST http://localhost:8080/api/donations \
-H "Content-Type: application/json" \
-d '{
    "userId": 1,
    "philanthropyId": 1,
    "amount": 150000
}'
```

### 4. Catat Pengeluaran

```bash
curl -X POST http://localhost:8080/api/expenses \
-H "Content-Type: application/json" \
-d '{
    "philanthropyId": 1,
    "description": "Bantuan sembako",
    "amount": 50000
}'
```

### 5. Lihat Data Keuangan (Ledger)

```bash
curl http://localhost:8080/api/philanthropies/1/ledger
```

## 💡 Contoh Response

### GET /api/philanthropies/1/ledger

```json
{
  "philanthropy": "Yayasan Peduli Sesama",
  "totalIncome": 150000,
  "totalExpense": 50000,
  "balance": 100000,
  "donations": [
    {
      "id": 1,
      "userId": 1,
      "amount": 150000,
      "createdAt": "2025-05-18T08:00:00"
    }
  ],
  "expenses": [
    {
      "id": 1,
      "description": "Bantuan sembako",
      "amount": 50000,
      "createdAt": "2025-05-18T08:30:00"
    }
  ]
}
```

## 🔥 Testing di Postman

1. Download Postman dari https://www.postman.com/downloads/
2. Buka Postman
3. Klik tombol "Import" di pojok kiri atas
4. Upload file `postman/donation-management-api.postman_collection.json`
5. Klik koleksi "Donation Management API"
6. Jalankan request sesuai urutan nomor:
   - Create Philanthropy dulu
   - Liat List Philanthropies
   - Create Donation
   - Create Expense
   - View Ledger

## ⚠️ Perhatikan

- Sebelum kirim donasi atau pengeluaran, pastikan buat philanthropy dulu ya!
- Saldo harus cukup untuk melakukan pengeluaran
- Semua jumlah dalam Rupiah
- API akan memberi pesan error kalau ada yang salah
