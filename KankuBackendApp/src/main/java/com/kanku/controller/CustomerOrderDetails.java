package com.kanku.controller;

import com.kanku.service.ICustomerOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerOrderDetails")
@CrossOrigin("*")
public class CustomerOrderDetails {

    @Autowired
    private ICustomerOrderDetailsService customerOrderDetailsService;

    @GetMapping("/getAllCustomerOrderDetails")
    public ResponseEntity<?> getAllCustomerOrderDetails(){
        return ResponseEntity.ok(customerOrderDetailsService.getAllCustomerOrderDetails());
    }
}
