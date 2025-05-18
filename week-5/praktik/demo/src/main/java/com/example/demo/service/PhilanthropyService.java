package com.example.demo.service;

import com.example.demo.dto.DonationRequest;
import com.example.demo.dto.ExpenseRequest;
import com.example.demo.dto.LedgerResponse;
import com.example.demo.dto.PhilanthropyRequest;
import com.example.demo.model.Donation;
import com.example.demo.model.Expense;
import com.example.demo.model.Philanthropy;
import com.example.demo.repository.DonationRepository;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.repository.PhilanthropyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class PhilanthropyService {
    
    @Autowired
    private PhilanthropyRepository philanthropyRepository;
    
    @Autowired
    private DonationRepository donationRepository;
    
    @Autowired
    private ExpenseRepository expenseRepository;
    
public List<Philanthropy> getAllPhilanthropies() {
        return philanthropyRepository.findAll();
    }
    
    public Philanthropy createPhilanthropy(PhilanthropyRequest request) {
        Philanthropy philanthropy = new Philanthropy();
        philanthropy.setName(request.getName());
        philanthropy.setBalance(0.0);
        return philanthropyRepository.save(philanthropy);
    }
    
    @Transactional
    public Donation createDonation(DonationRequest request) {
        Philanthropy philanthropy = philanthropyRepository.findById(request.getPhilanthropyId())
            .orElseThrow(() -> new RuntimeException("Philanthropy not found"));
            
        Donation donation = new Donation();
        donation.setUserId(request.getUserId());
        donation.setPhilanthropy(philanthropy);
        donation.setAmount(request.getAmount());
        
        philanthropy.setBalance(philanthropy.getBalance() + request.getAmount());
        philanthropyRepository.save(philanthropy);
        
        return donationRepository.save(donation);
    }
    
    @Transactional
    public Expense createExpense(ExpenseRequest request) {
        Philanthropy philanthropy = philanthropyRepository.findById(request.getPhilanthropyId())
            .orElseThrow(() -> new RuntimeException("Philanthropy not found"));
            
        if (philanthropy.getBalance() < request.getAmount()) {
            throw new RuntimeException("Insufficient funds");
        }
        
        Expense expense = new Expense();
        expense.setPhilanthropy(philanthropy);
        expense.setDescription(request.getDescription());
        expense.setAmount(request.getAmount());
        
        philanthropy.setBalance(philanthropy.getBalance() - request.getAmount());
        philanthropyRepository.save(philanthropy);
        
        return expenseRepository.save(expense);
    }
    
    public LedgerResponse getLedger(Long philanthropyId) {
        Philanthropy philanthropy = philanthropyRepository.findById(philanthropyId)
            .orElseThrow(() -> new RuntimeException("Philanthropy not found"));
            
        List<Donation> donations = donationRepository.findByPhilanthropyId(philanthropyId);
        List<Expense> expenses = expenseRepository.findByPhilanthropyId(philanthropyId);
        
        Double totalIncome = donations.stream()
            .mapToDouble(Donation::getAmount)
            .sum();
            
        Double totalExpense = expenses.stream()
            .mapToDouble(Expense::getAmount)
            .sum();
            
        LedgerResponse response = new LedgerResponse();
        response.setPhilanthropy(philanthropy.getName());
        response.setTotalIncome(totalIncome);
        response.setTotalExpense(totalExpense);
        response.setBalance(philanthropy.getBalance());
        response.setDonations(donations);
        response.setExpenses(expenses);
        
        return response;
    }
}
