package com.hardeymorlah.RewardsManagementAPI.controller;

import com.hardeymorlah.RewardsManagementAPI.model.CashbackHistory;
import com.hardeymorlah.RewardsManagementAPI.model.CustomerRewards;
import com.hardeymorlah.RewardsManagementAPI.service.CashbackHistoryService;
import com.hardeymorlah.RewardsManagementAPI.service.CustomerRewardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rewards")
public class RewardsManagementAPIController {
    @Autowired
    private CustomerRewardService customerRewardService;
    @Autowired
    private CashbackHistoryService cashbackHistoryService;

    @GetMapping("/balance/{customerId}")
    public ResponseEntity<CustomerRewards> getRewards(@Valid @PathVariable Long customerId) {
        return customerRewardService.getCustomerRewards(customerId);
    }
    @GetMapping("/history")
    public ResponseEntity<List<CashbackHistory>> getCashbackHistory(@Valid @RequestParam Long customerId) {
        return cashbackHistoryService.getCashbackHistory(customerId);
    }
}
