# 📸 Visualisasi API Expenses

## 1. Arsitektur API Sederhana

```mermaid
graph LR
    A[Client/Postman] -->|HTTP Request| B[Spring Boot API]
    B -->|JSON Response| A
    B -->|Simpan Data| C[ArrayList<br>In Memory]

    style A fill:#85C1E9
    style B fill:#82E0AA
    style C fill:#F8C471
```

## 2. Alur Request GET

```mermaid
sequenceDiagram
    participant C as Client
    participant A as API
    participant M as Memory

    C->>A: GET /expenses
    A->>M: Ambil semua data
    M-->>A: List expenses
    A-->>C: JSON Array Response
```

## 3. Alur Request POST

```mermaid
flowchart TD
    A[POST Request] --> B{Cek Nama<br>Expense}
    B -->|Nama Baru| C[Tambah ke List]
    B -->|Nama Sudah Ada| D[Update Amount]
    C --> E[Return 201 Created]
    D --> F[Return 200 OK]

    style A fill:#AED6F1
    style B fill:#F9E79F
    style C,D fill:#82E0AA
    style E,F fill:#F1948A
```

## 4. Contoh Response

### GET /expenses

```mermaid
graph TD
    A[Response] --> B["[<br>
    {name: 'Makan', amount: 25000},<br>
    {name: 'Transport', amount: 15000}<br>
    ]"]

    style A fill:#85C1E9
    style B fill:#82E0AA
```

### POST /expenses (Nama Baru)

```mermaid
graph TD
    A[Request Body] --> B["{<br>name: 'Snack',<br>amount: 10000<br>}"]
    B --> C[Response: 201 Created]

    style A fill:#85C1E9
    style B fill:#F8C471
    style C fill:#82E0AA
```

### POST /expenses (Update)

```mermaid
graph TD
    A[Request Body] --> B["{<br>name: 'Makan',<br>amount: 15000<br>}"]
    B --> C["Response: 200 OK<br>{<br>name: 'Makan',<br>amount: 40000<br>}"]

    style A fill:#85C1E9
    style B fill:#F8C471
    style C fill:#82E0AA
```

## 💡 Penjelasan

1. **Simpan Data**:

   - Semua data disimpan di ArrayList
   - Data bersifat sementara (in-memory)

2. **GET Request**:

   - Client minta data
   - API ambil dari ArrayList
   - Return dalam format JSON

3. **POST Request**:

   - Client kirim data baru
   - API cek nama expense
   - Kalau baru = tambah
   - Kalau ada = update jumlah

4. **Response Status**:
   - 201: Berhasil tambah baru
   - 200: Berhasil update
   - Format selalu JSON
