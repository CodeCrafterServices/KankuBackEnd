package com.kanku.controller;

import com.kanku.model.Customer;
import com.kanku.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/customerProfile")
    public ResponseEntity<Customer> getCustomerProfile(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.getCustomerByUsername(customer.getUsername()));
    }

    @PutMapping("/updateProfile")
    public ResponseEntity<Customer> updateProfile(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.updateCustomerByUsername(customer));
    }

}
