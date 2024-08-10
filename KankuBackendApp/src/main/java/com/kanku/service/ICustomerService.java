package com.kanku.service;

import com.kanku.model.Customer;

import java.util.Optional;

public interface ICustomerService {

    Customer registerCustomer(Customer customer);

    Customer updateCustomerByUsername(Customer customer);

    Boolean getCustomerByEmail(String username);
    Customer getCustomerByUsername(String username);
}
