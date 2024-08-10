package com.kanku.controller;

import com.kanku.model.BatchProductSize;
import com.kanku.model.Product;
import com.kanku.model.Size;
import com.kanku.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/size")
@CrossOrigin("*")
public class SizeController {

    @Autowired
    private ISizeService sizeService;

    @PostMapping("/addSize")
    public ResponseEntity<?> addSize(@RequestBody BatchProductSize batchProductSize){
        return ResponseEntity.ok(sizeService.addSize(batchProductSize));
    }

    @PostMapping("/getSizeByProductId")
    public  ResponseEntity<?> getProductSizeById(@RequestBody Size size){
        List<Size> sizeByProductId = sizeService.getSizeByProductId(size);
        if(sizeByProductId.isEmpty()){
            System.out.println("Sizes are null");
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(sizeService.getSizeByProductId(size));
    }

    @PostMapping("/getUniqueSizeByProduct")
    public ResponseEntity<?> getUniqueProductSize(@RequestBody Product product){
        return ResponseEntity.ok(sizeService.getUniqueProductSizes(product.getProductId()));
    }
}
