package com.hardeymorlah.RewardsManagementAPI.dto;

import lombok.Data;

@Data
public class CustomerRewardsDTO {
    private Long customerId;
    private Double totalCashback;
    private Double currentBalance;

}
