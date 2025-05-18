package com.example.demo.dto;

import com.example.demo.model.Donation;
import com.example.demo.model.Expense;
import lombok.Data;
import java.util.List;

@Data
public class LedgerResponse {
    private String philanthropy;
    private Double totalIncome;
    private Double totalExpense;
    private Double balance;
    private List<Donation> donations;
    private List<Expense> expenses;
}
