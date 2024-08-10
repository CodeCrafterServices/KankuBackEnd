package com.kanku.controller;

import com.kanku.model.Cart;
import com.kanku.model.Customer;
import com.kanku.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin("*")
public class CartController {

    @Autowired
    private ICartService cartService;

    @PostMapping("/addToCart")
    public ResponseEntity<?> addToCart(@RequestBody Cart cart){
      return ResponseEntity.ok(cartService.addToCart(cart));
    }

    @PostMapping("/deleteCartItem")
    public ResponseEntity<?> deleteCart(@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.deleteCartById(cart.getCartId()));
    }

    @PostMapping("/getCartsByCustomer")
    public ResponseEntity<?> getAllCartsByCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(cartService.getAllCartsByCustomer(customer.getCustomerId()));
    }

    @PutMapping("/updateCartQuantity")
    public ResponseEntity<?> updateCartQuantity(@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.updateCartQuantity(cart));
    }

}
