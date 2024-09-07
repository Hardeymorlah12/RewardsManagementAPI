package com.hardeymorlah.RewardsManagementAPI.service;

import com.hardeymorlah.RewardsManagementAPI.model.CashbackHistory;
import com.hardeymorlah.RewardsManagementAPI.model.Customer;
import com.hardeymorlah.RewardsManagementAPI.model.CustomerRewards;
import com.hardeymorlah.RewardsManagementAPI.model.Transaction;
import com.hardeymorlah.RewardsManagementAPI.repository.CashbackHistoryRepository;
import com.hardeymorlah.RewardsManagementAPI.repository.CustomerRepository;
import com.hardeymorlah.RewardsManagementAPI.repository.CustomerRewardsRepository;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CustomerRewardService {
    @Autowired
    private CustomerRewardsRepository customerRewardsRepository;
    @Autowired
    private CashbackHistoryRepository cashbackHistoryRepository;
    @Autowired
    private CustomerRepository customerRepository;


                // This updates the CustomerRewards Table in the Database
    public void processTransaction(Transaction transaction) {
        CustomerRewards customerRewards = customerRewardsRepository.findByCustomer(transaction.getCustomer());
        if (customerRewards == null) {
            customerRewards = new CustomerRewards();
            customerRewards.setCustomer(transaction.getCustomer());
        }
        customerRewards.setTotalCashback(customerRewards.getTotalCashback() + transaction.getAmount() * 0.05);
        customerRewards.setCurrentBalance(customerRewards.getCurrentBalance() + transaction.getAmount() * 0.05);
        customerRewards.setCustomer(transaction.getCustomer());
        customerRewardsRepository.save(customerRewards);

        CashbackHistory cashbackHistory = getCashbackHistory(transaction);
        cashbackHistoryRepository.save(cashbackHistory);
    }
                    // This updates the CashbackHistory Table in the Database
    private static CashbackHistory getCashbackHistory(Transaction transaction) {
        CashbackHistory cashbackHistory = new CashbackHistory();
        cashbackHistory.setTransaction(transaction);
        cashbackHistory.setAmountEarned(transaction.getAmount() * 0.05);
        cashbackHistory.setTransactionDate(transaction.getTransactionDate());
        cashbackHistory.setTransactionDate(transaction.getTransactionDate());
        cashbackHistory.setTransactionDate(transaction.getTransactionDate());
        cashbackHistory.setDescription(transaction.getDescription());
        cashbackHistory.setCustomer(transaction.getCustomer());
        return cashbackHistory;
    }

    public ResponseEntity<CustomerRewards> getCustomerRewards(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        return new ResponseEntity<>(customerRewardsRepository.findByCustomer(customer), HttpStatus.OK);




//    public ResponseEntity<CustomerRewards> getCustomerRewards(@Valid Long customerId) {
//            return new ResponseEntity<>(customerRewardsRepository.findByCustomer(new Customer(customerId)), HttpStatus.OK);
        } }

