package com.hardeymorlah.RewardsManagementAPI.service;

import com.hardeymorlah.RewardsManagementAPI.model.Customer;
import com.hardeymorlah.RewardsManagementAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<Customer> getCustomerById(Long id) {
        return new ResponseEntity<>(customerRepository.findById(id).orElse(null), HttpStatus.OK);
    }

    public ResponseEntity<Customer> getCustomerByName(String name) {
        return new ResponseEntity<>(customerRepository.findByName(name), HttpStatus.OK);
    }
    public ResponseEntity<Customer> createCustomer(Customer newCustomer) {
        newCustomer.setName(newCustomer.getName());
        newCustomer.setUsername(newCustomer.getUsername());
        newCustomer.setPhoneNumber(newCustomer.getPhoneNumber());
        newCustomer.setPassword(newCustomer.getPassword());
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
