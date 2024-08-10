package com.kanku.controller;

import com.kanku.model.ProductOrder;
import com.kanku.model.dto.ProductOrderDto;
import com.kanku.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/orderProduct")
    public ResponseEntity orderProduct(@RequestBody ProductOrderDto productOrderDto){

        System.out.println("====>"+productOrderDto);
        return ResponseEntity.ok(orderService.orderProduct(productOrderDto));
    }

    @PutMapping("/confirmDelivery/{orderId}")
    public ResponseEntity<?> confirmDelivery(@PathVariable("orderId") Long orderId){
             return ResponseEntity.ok(orderService.confirmDelivery(orderId));
    }


}
