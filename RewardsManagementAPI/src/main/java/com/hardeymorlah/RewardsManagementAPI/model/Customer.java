package com.hardeymorlah.RewardsManagementAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Setter;
import lombok.Setter;
import lombok.Setter;

@Entity
@Table(name = "customer_table")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @NotNull
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 100, message = "Name must be more than 2, and less than 100 characters")
    private String name;
    @Setter
    @NotNull
    @NotBlank(message = "Email is mandatory")
    @Email
    @Column (name = "email", unique = true)
    private String username;

    @Column(name = "password")
    @Setter
    @NotNull
    @NotBlank(message = "Password must contain a minimum of 8 and a maximum of 13 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$!%+=^*?&]).{8,}$")
    private String password;
    @NotEmpty
    @Setter
    @NotBlank(message = "phone number is mandatory")
    @NotNull
    private String phoneNumber;


    public Customer(Long customerId) {
    }
}
