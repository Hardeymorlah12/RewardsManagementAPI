package com.hardeymorlah.RewardsManagementAPI.repository;

import com.hardeymorlah.RewardsManagementAPI.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
