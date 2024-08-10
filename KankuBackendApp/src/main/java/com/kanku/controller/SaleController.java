package com.kanku.controller;

import com.kanku.model.Sales;
import com.kanku.service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale")
@CrossOrigin("*")public class SaleController {

    @Autowired
    private ISalesService salesService;

    @PostMapping("/saleProduct")
    public ResponseEntity<?> saleProduct(@RequestBody Sales sales){

        return ResponseEntity.ok(salesService.saleProduct(sales));
    }
}
