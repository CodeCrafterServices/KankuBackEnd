package com.kanku.controller;

import com.kanku.service.IPendingOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pendingOrders")
@CrossOrigin("*")
public class PendingOrderDetails {

    @Autowired
    private IPendingOrders pendingOrders;

    @GetMapping("/pendingOrderDetails")
    public ResponseEntity<?> pendOrderDetails(){

        return ResponseEntity.ok(pendingOrders.getAllPendingOrders());
    }

}