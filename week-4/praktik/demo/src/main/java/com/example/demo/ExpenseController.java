package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    
    // Simpan data di memory pake ArrayList
    private List<Expense> expenses = new ArrayList<>();

    // GET /expenses - Tampilkan semua pengeluaran
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenses;
    }

    // POST /expenses - Tambah atau update pengeluaran
    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody Expense newExpense) {
        // Cari apakah nama pengeluaran sudah ada
        for (Expense expense : expenses) {
            if (expense.getName().equals(newExpense.getName())) {
                // Kalo nama udah ada, tambahin amountnya
                expense.setAmount(expense.getAmount() + newExpense.getAmount());
                return ResponseEntity.ok(expense); // Return 200 OK
            }
        }

        // Kalo nama belum ada, tambahkan sebagai item baru
        expenses.add(newExpense);
        return ResponseEntity.status(HttpStatus.CREATED).body(newExpense); // Return 201 Created
    }
}
