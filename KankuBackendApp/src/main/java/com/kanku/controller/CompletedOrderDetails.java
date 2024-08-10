package com.kanku.controller;


import com.kanku.service.ICompletedOrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/completedOrders")
public class CompletedOrderDetails {

    @Autowired
    private ICompletedOrderDetails completedOrderDetails;

    @GetMapping("/completedOrderDetails")
    public ResponseEntity<?> completedOrderDetails(){

        return ResponseEntity.ok(completedOrderDetails.getAllCompletedOrders());
    }
}