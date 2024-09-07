package com.hardeymorlah.RewardsManagementAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String product;
    private Double amount;
    private Date transactionDate;
    @NotBlank
    private String description;
    @Getter
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}

