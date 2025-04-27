# 🌡️ Pseudocode Konversi Suhu

Halo teman-teman! Di sini aku bakal jelasin cara bikin program konversi suhu pake pseudocode (semacam resep masak gitu). Gampang kok, ikutin aja ya! 😊

## 📝 Program Konversi Suhu

```
// Ini cetakan (Class) untuk konversi suhu kita
Class KonversiSuhu:
    // Ini tempat nyimpen suhunya
    Property:
        celsius

    // Ini fungsi buat ngeset suhu awalnya
    Method setSuhu(nilai):
        celsius = nilai

    // Fungsi buat ngubah ke Fahrenheit
    Method keFahrenheit():
        Mulai
            hasil = (celsius × 9/5) + 32
            Tampilkan "Suhu dalam Fahrenheit: " + hasil + "°F"
            Return hasil
        Selesai

    // Fungsi buat ngubah ke Reamur
    Method keReamur():
        Mulai
            hasil = celsius × 4/5
            Tampilkan "Suhu dalam Reamur: " + hasil + "°R"
            Return hasil
        Selesai

    // Fungsi buat ngubah ke Kelvin
    Method keKelvin():
        Mulai
            hasil = celsius + 273.15
            Tampilkan "Suhu dalam Kelvin: " + hasil + "K"
            Return hasil
        Selesai

// Cara makenya gimana?
Mulai Program
    // Bikin objek konversi suhu baru
    konverter = Object Baru dari KonversiSuhu

    // Minta user masukin suhu dalam Celsius
    Tampilkan "Masukkan suhu dalam Celsius: "
    input = Baca input dari user

    // Set suhu yang dimasukin user
    konverter.setSuhu(input)

    // Konversi ke semua satuan suhu
    konverter.keFahrenheit()
    konverter.keReamur()
    konverter.keKelvin()
Selesai Program
```

## 🎯 Cara Kerjanya Gimana?

1. Pertama kita bikin cetakan (Class) namanya `KonversiSuhu`
2. Di dalemnya ada:

   - Tempat nyimpen suhu Celsius
   - Fungsi buat ngatur suhunya
   - Fungsi-fungsi buat ngubah ke satuan lain

3. Cara pakenya:
   - Bikin objek baru dari cetakan tadi
   - Masukin suhu Celsius yang mau diubah
   - Panggil fungsi-fungsi konversinya

## 💡 Tips Ngoding

- Inget rumusnya:

  - Fahrenheit = (C × 9/5) + 32
  - Reamur = C × 4/5
  - Kelvin = C + 273.15

- Jangan lupa tampilin satuannya:
  - Fahrenheit pake °F
  - Reamur pake °R
  - Kelvin pake K aja

Nah, gampang kan? Sekarang coba bikin programnya ya! Semangat! 🔥
