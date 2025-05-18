package com.example.demo.controller;

import com.example.demo.dto.DonationRequest;
import com.example.demo.dto.ExpenseRequest;
import com.example.demo.dto.LedgerResponse;
import com.example.demo.dto.PhilanthropyRequest;
import com.example.demo.model.Donation;
import com.example.demo.model.Expense;
import com.example.demo.model.Philanthropy;
import com.example.demo.service.PhilanthropyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PhilanthropyController {

    @Autowired
    private PhilanthropyService philanthropyService;

    @GetMapping("/philanthropies")
    public ResponseEntity<List<Philanthropy>> getAllPhilanthropies() {
        return ResponseEntity.ok(philanthropyService.getAllPhilanthropies());
    }

    @PostMapping("/philanthropies")
    public ResponseEntity<Philanthropy> createPhilanthropy(@RequestBody PhilanthropyRequest request) {
        return ResponseEntity.ok(philanthropyService.createPhilanthropy(request));
    }

    @PostMapping("/donations")
    public ResponseEntity<Donation> createDonation(@RequestBody DonationRequest request) {
        return ResponseEntity.ok(philanthropyService.createDonation(request));
    }

    @PostMapping("/expenses")
    public ResponseEntity<Expense> createExpense(@RequestBody ExpenseRequest request) {
        return ResponseEntity.ok(philanthropyService.createExpense(request));
    }

    @GetMapping("/philanthropies/{id}/ledger")
    public ResponseEntity<LedgerResponse> getLedger(@PathVariable Long id) {
        return ResponseEntity.ok(philanthropyService.getLedger(id));
    }
}
