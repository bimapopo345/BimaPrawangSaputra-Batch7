package com.example.demo.dto;

import lombok.Data;

@Data
public class ExpenseRequest {
    private Long philanthropyId;
    private String description;
    private Double amount;
}
