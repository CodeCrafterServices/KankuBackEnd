package com.kanku.service;

import com.kanku.model.Cart;

import java.util.List;

public interface ICartService {

    Cart addToCart(Cart cart);
    String deleteCartById(Long cartId);

    List<Cart> getAllCartsByCustomer(Long id);

    Cart updateCartQuantity(Cart cart);

    String deleteCartsByCustomer(Long customerId);
}
