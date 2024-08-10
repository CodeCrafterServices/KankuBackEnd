package com.kanku.service.impl;

import com.kanku.model.Cart;
import com.kanku.repository.ICartRepository;
import com.kanku.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Override
    public Cart addToCart(Cart cart) {
        cart.setCartDate(LocalDate.now());
        return cartRepository.save(cart);
    }

    @Override
    public String deleteCartById(Long cartId) {
        cartRepository.deleteById(cartId);
        if(cartRepository.existsById(cartId)){
            return "product not removed from cart...!";
        }else{
            return "product removed from cart...!";
        }
    }

    @Override
    public List<Cart> getAllCartsByCustomer(Long id) {
        return cartRepository.getAllByCustomerCustomerId(id);
    }

    @Override
    public Cart updateCartQuantity(Cart cart) {

        Cart c=cartRepository.findById(cart.getCartId()).get();

        c.setCartProductQuantity(cart.getCartProductQuantity());
        return cartRepository.save(c);
    }

    @Override
    public String deleteCartsByCustomer(Long customerId) {

        cartRepository.deleteCartsByCustomerId(customerId);
        return "Cart are deleted by customer id...!";
    }


}
