package com.kanku.controller;

import com.kanku.model.TransactionDetails;
import com.kanku.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;



//    @PostMapping("/placeOrder")
//    public TransactionDetails placeOrder(@RequestBody Order order){
//        System.out.println(order);
//        return paymentService.createTransaction(order.getAmount());
//    }
//
//    @GetMapping("/createTransaction/{amount}")
//    public TransactionDetails createTransaction(@PathVariable("amount")  Double amount){
//        return paymentService.createTransaction(amount);
//    }




}