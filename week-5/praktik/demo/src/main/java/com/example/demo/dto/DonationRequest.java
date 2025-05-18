package com.example.demo.dto;

import lombok.Data;

@Data
public class DonationRequest {
    private Long userId;
    private Long philanthropyId;
    private Double amount;
}
