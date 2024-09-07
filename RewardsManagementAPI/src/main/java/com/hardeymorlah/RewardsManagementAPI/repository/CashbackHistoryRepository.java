package com.hardeymorlah.RewardsManagementAPI.repository;

import com.hardeymorlah.RewardsManagementAPI.model.CashbackHistory;
import com.hardeymorlah.RewardsManagementAPI.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashbackHistoryRepository extends JpaRepository<CashbackHistory, Long> {
    List<CashbackHistory> findByCustomer(Customer customer);

}
