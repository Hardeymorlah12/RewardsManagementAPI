package com.hardeymorlah.RewardsManagementAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "cashbackHistory_table")
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CashbackHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;
    @ManyToOne
    @Setter
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Setter
    private Date transactionDate;
    @Setter
    private double amountEarned;
    @Setter
    @NotBlank
    private String description;
}
