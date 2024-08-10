package com.kanku.service.impl;

import com.kanku.model.Customer;
import com.kanku.repository.ICustomerRepository;
import com.kanku.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CustomerCustomServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Customer registerCustomer(Customer customer) {

        if(customerRepository.findByUsername(customer.getUsername())==null){
            customer.setDate(LocalDate.now());
            return customerRepository.save(customer);
        }
        return null;
    }

    @Override
    public Customer updateCustomerByUsername(Customer customer) {
        Optional<Customer> customerByUsername = customerRepository.getCustomerByUsername(customer.getUsername());
        if(customerByUsername.isPresent()){
            customerByUsername.get().setCustomerId(customer.getCustomerId());
            customerByUsername.get().setUsername(customer.getUsername());
            customerByUsername.get().setFullName(customer.getFullName());
            customerByUsername.get().setContact(customer.getContact());
            customerByUsername.get().setAddress(customer.getAddress());
            customerByUsername.get().setPinCode(customer.getPinCode());
            return customerRepository.save(customerByUsername.get());
        }
        return null;
    }


    @Override
    public Boolean getCustomerByEmail(String username) {
        Optional<Customer> customerByUsername = customerRepository.getCustomerByUsername(username);
        return customerByUsername.isPresent();
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerRepository.getCustomerByUsername(username).get();
    }


}
