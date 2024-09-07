package com.hardeymorlah.RewardsManagementAPI.controller;

import com.hardeymorlah.RewardsManagementAPI.model.Customer;
import com.hardeymorlah.RewardsManagementAPI.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/new_customer")
    public ResponseEntity<Customer> postCustomer(@RequestBody @Valid Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/customer_by_name")
    public ResponseEntity<Customer> getCustomerByName(@RequestParam @Valid String name) {
        return customerService.getCustomerByName(name);
    }

    @GetMapping("/customer_by_id/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable @Valid Long id) {
        return customerService.getCustomerById(id);
    }
    @PutMapping("/updateCustomer_by_id/{id}")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer updatedCustomer,@PathVariable Long id) {
        return customerService.updateCustomer(updatedCustomer, id);
    }
    @DeleteMapping("/deleteCustomer_by_id")
    public ResponseEntity<Customer> deleteCustomer(@Valid @RequestParam Long id) {
        return customerService.deleteCustomer(id);
    }
}
