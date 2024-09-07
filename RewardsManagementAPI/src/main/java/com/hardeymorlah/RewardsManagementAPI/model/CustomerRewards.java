package com.hardeymorlah.RewardsManagementAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customerRewards_table")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRewards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Setter
    private double totalCashback;
    @Setter
    private double currentBalance;
}
