package com.kanku.controller;

import com.kanku.model.Supplier;
import com.kanku.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
@CrossOrigin("*")
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;

    @PostMapping("/addSupplier")
    public ResponseEntity addSupplier(@RequestBody Supplier supplier){
        return ResponseEntity.ok(supplierService.addSupplier(supplier));
    }
}
