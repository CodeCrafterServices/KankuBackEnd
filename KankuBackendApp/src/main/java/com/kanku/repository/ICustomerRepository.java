package com.kanku.repository;

import com.kanku.model.Customer;
import com.kanku.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByUsername(String email);
    Customer getCustomerByUsernameAndPassword(String email,String password);
    Optional<Customer> getCustomerByUsername(String username);
//    Boolean getCustomerByUsername(String username);
}
