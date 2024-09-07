package com.hardeymorlah.RewardsManagementAPI.repository;

import com.hardeymorlah.RewardsManagementAPI.model.Customer;
import com.hardeymorlah.RewardsManagementAPI.model.CustomerRewards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRewardsRepository extends JpaRepository<CustomerRewards, Long> {
    CustomerRewards findByCustomer(Customer customer);
}
