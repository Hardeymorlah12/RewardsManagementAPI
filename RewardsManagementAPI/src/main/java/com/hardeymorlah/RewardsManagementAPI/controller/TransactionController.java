package com.hardeymorlah.RewardsManagementAPI.controller;

import com.hardeymorlah.RewardsManagementAPI.model.Transaction;
import com.hardeymorlah.RewardsManagementAPI.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/post_transaction")
    public ResponseEntity<Transaction> postTransaction(@Valid @RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }
    @GetMapping("/get_transaction/{id}")
    public ResponseEntity<Transaction> getTransaction(Long id) {
        return transactionService.getTransaction(id);
    }
}
