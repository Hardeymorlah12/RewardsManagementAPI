package com.hardeymorlah.RewardsManagementAPI.service;

import com.hardeymorlah.RewardsManagementAPI.config.AccountConfiguration;
import com.hardeymorlah.RewardsManagementAPI.model.Customer;
import com.hardeymorlah.RewardsManagementAPI.Enum.Role;
import com.hardeymorlah.RewardsManagementAPI.dto.LoginRequest;
import com.hardeymorlah.RewardsManagementAPI.dto.LoginResponse;
import com.hardeymorlah.RewardsManagementAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccountConfiguration accountConfiguration;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Customer> getCustomerById(Long id) {
        return new ResponseEntity<>(customerRepository.findById(id).orElse(null), HttpStatus.OK);
    }

    public ResponseEntity<LoginResponse> authenticate(LoginRequest request) {

        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));


        if( auth != null ){
            Customer user = customerRepository.findByUsername(request.getUsername());
            System.out.println(user);
            String token = jwtService.createToken(user);
            System.out.println(token);
            return new ResponseEntity<>(LoginResponse.builder().user(user).token(token).build(), HttpStatus.OK);
        } else {
            System.out.println("auth is null");
        }

        return null;
    }

    public ResponseEntity<Customer> getCustomerByName(String name) {
        return new ResponseEntity<>(customerRepository.findByName(name), HttpStatus.OK);
    }
    public ResponseEntity<Customer> createCustomer(Customer newCustomer) {
        passwordEncoder = accountConfiguration.passwordEncoder();
        if (newCustomer.getRole() == null) {
            newCustomer.setRole(Role.USER);
        }
        newCustomer.setName(newCustomer.getName());
        newCustomer.setUsername(newCustomer.getUsername());
        newCustomer.setPhoneNumber(newCustomer.getPhoneNumber());
        newCustomer.setPassword(passwordEncoder.encode(newCustomer.getPassword()));
        return new ResponseEntity<>(customerRepository.save(newCustomer), HttpStatus.CREATED);
    }

    public ResponseEntity<Customer> updateCustomer(Customer updatedCustomer, Long id) {
    Customer existingCustomer = customerRepository.findById(id).orElse(null);
        assert existingCustomer != null;
        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
        existingCustomer.setPassword(updatedCustomer.getPassword());
        existingCustomer.setUsername(updatedCustomer.getUsername());
        return new ResponseEntity<>(customerRepository.save(existingCustomer), HttpStatus.ACCEPTED);
    }
    public ResponseEntity<Customer> deleteCustomer(Long id) {
    Customer deletedCustomer = customerRepository.findById(id).orElse(null);
    customerRepository.deleteById(id);
    return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
    }
}
