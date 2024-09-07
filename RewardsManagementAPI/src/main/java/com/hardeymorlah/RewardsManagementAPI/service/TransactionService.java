package com.hardeymorlah.RewardsManagementAPI.service;

import com.hardeymorlah.RewardsManagementAPI.model.Transaction;
//import com.hardeymorlah.RewardsManagementAPI.repository.CustomerRewardsRepository;
import com.hardeymorlah.RewardsManagementAPI.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CustomerRewardService customerRewardService;

    public ResponseEntity<Transaction> createTransaction(Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        customerRewardService.processTransaction(savedTransaction);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    public ResponseEntity<Transaction> getTransaction(Long id) {
        return new ResponseEntity<>(transactionRepository.findById(id).orElse(null), HttpStatus.OK);
    }
}