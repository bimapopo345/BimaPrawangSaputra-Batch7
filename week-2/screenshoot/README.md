# 📸 Visual Pembelajaran OOP dan Konversi Suhu

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

## 3. Hubungan Konversi Suhu

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

## 4. Mindmap OOP

```mermaid
mindmap
  root((OOP))
    (Class)
        [Cetakan/Template]
        [Blueprint program]
        [Definisi sifat & kemampuan]
    (Object)
        [Instance dari Class]
        [Hasil cetakan]
        [Bisa banyak object]
    (Properties)
        [Sifat-sifat]
        [Data/Nilai]
        [Variabel dalam class]
    (Methods)
        [Kemampuan/Fungsi]
        [Aksi yang bisa dilakukan]
        [Bisa mengubah properties]
```

## 5. Mindmap Konversi Suhu

```mermaid
mindmap
  root((Konversi))
    (Celsius)
        [Suhu dasar]
        [0° = Air beku]
        [100° = Air mendidih]
    (Fahrenheit)
        [C × 9/5 + 32]
        [32° = Air beku]
        [212° = Air mendidih]
    (Reamur)
        [C × 4/5]
        [0° = Air beku]
        [80° = Air mendidih]
    (Kelvin)
        [C + 273.15]
        [273.15K = Air beku]
        [373.15K = Air mendidih]
```

## 📝 Catatan

Diagram-diagram di atas menjelaskan:

1. Struktur class dan alur program konversi suhu
2. Hubungan dan rumus konversi antar satuan suhu
3. Konsep OOP dengan mindmap yang mudah dipahami
4. Detail setiap satuan suhu dan titik-titik pentingnya

Kalau ada yang mau ditanyakan, langsung tanya ya! 😊
