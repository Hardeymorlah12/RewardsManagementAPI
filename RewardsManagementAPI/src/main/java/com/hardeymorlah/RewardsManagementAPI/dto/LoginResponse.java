package com.hardeymorlah.RewardsManagementAPI.dto;

import com.hardeymorlah.RewardsManagementAPI.model.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

    private Customer user;
    private String token;

}
