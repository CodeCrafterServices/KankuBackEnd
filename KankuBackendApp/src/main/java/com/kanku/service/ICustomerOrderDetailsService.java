package com.kanku.service;

import com.kanku.model.dto.CustomerOrderDetailsDto;

import java.util.List;

public interface ICustomerOrderDetailsService {

    List<CustomerOrderDetailsDto> getAllCustomerOrderDetails();
}
