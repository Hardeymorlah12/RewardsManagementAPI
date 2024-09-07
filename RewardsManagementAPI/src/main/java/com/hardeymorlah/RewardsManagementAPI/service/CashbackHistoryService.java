package com.hardeymorlah.RewardsManagementAPI.service;

import com.hardeymorlah.RewardsManagementAPI.model.CashbackHistory;
import com.hardeymorlah.RewardsManagementAPI.model.Customer;
import com.hardeymorlah.RewardsManagementAPI.model.Transaction;
import com.hardeymorlah.RewardsManagementAPI.repository.CashbackHistoryRepository;
import com.hardeymorlah.RewardsManagementAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CashbackHistoryService {
    @Autowired
    private CashbackHistoryRepository cashbackHistoryRepository;
    @Autowired
    private CustomerRepository customerRepository;


    public ResponseEntity<List<CashbackHistory>> getCashbackHistory(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        return new ResponseEntity<>(cashbackHistoryRepository.findByCustomer(customer), HttpStatus.OK);
    }









//    public ResponseEntity<List<CashbackHistory>> getCashbackHistory(Long customerId) {
//        return new ResponseEntity<>(cashbackHistoryRepository.findByCustomer(new Customer(customerId)), HttpStatus.OK);
    }

