package com.hardeymorlah.RewardsManagementAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hardeymorlah.RewardsManagementAPI.Enum.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "customer_table")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements UserDetails {
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

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private Role role;


    public Customer(Long customerId) {
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
