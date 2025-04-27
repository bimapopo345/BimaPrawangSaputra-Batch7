# 🔄 Alur OOP dan Konversi Suhu

## 1. Diagram Konsep OOP

```mermaid
classDiagram
    class KonversiSuhu {
        +celcius
        +setCelcius(nilai)
        +keFahrenheit()
        +keReamur()
        +keKelvin()
    }

    note for KonversiSuhu "Ini adalah cetakan (Class)\nuntuk konversi suhu kita"
```

## 2. Alur Program

```mermaid
flowchart TD
    A[Start] --> B[Input Suhu Celcius]
    B --> C[Buat Object KonversiSuhu]
    C --> D[Set Nilai Celcius]
    D --> E{Pilih Konversi}
    E -->|1| F[Ke Fahrenheit]
    E -->|2| G[Ke Reamur]
    E -->|3| H[Ke Kelvin]
    F --> I[Tampilkan Hasil]
    G --> I
    H --> I
    I --> J[Selesai]

    style A fill:#d4f1f4
    style B fill:#e8f6f7
    style C fill:#e8f6f7
    style D fill:#e8f6f7
    style E fill:#ffeb99
    style F fill:#c9e4c5
    style G fill:#c9e4c5
    style H fill:#c9e4c5
    style I fill:#ffdcdc
    style J fill:#d4f1f4
```

## 3. Hubungan Antar Suhu

```mermaid
graph LR
    A((Celsius)) -->|× 9/5 + 32| B((Fahrenheit))
    A -->|× 4/5| C((Reamur))
    A -->|+ 273.15| D((Kelvin))

    style A fill:#ff9999
    style B fill:#99ff99
    style C fill:#9999ff
    style D fill:#ffff99
```

## 4. Cara Kerja OOP

```mermaid
flowchart LR
    A[Class\nCetakan] -->|Buat Object| B[Object\nHasil Cetakan]
    B -->|Punya| C[Properties\nSifat-sifat]
    B -->|Bisa| D[Methods\nKemampuan]

    style A fill:#ffcce6
    style B fill:#cce6ff
    style C fill:#e6ffcc
    style D fill:#ffe6cc
```

Nah, dari diagram-diagram di atas, kita bisa lihat:

1. Bagaimana struktur class KonversiSuhu
2. Alur program dari mulai sampai selesai
3. Rumus-rumus konversi antar satuan suhu
4. Konsep dasar OOP yang kita pake

Keren kan? 😎
