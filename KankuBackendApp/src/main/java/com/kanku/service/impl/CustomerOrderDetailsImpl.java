package com.kanku.service.impl;

import com.kanku.model.Customer;
import com.kanku.model.Product;
import com.kanku.model.Size;
import com.kanku.model.dto.CustomerOrderDetailsDto;
import com.kanku.repository.ICustomerOrderDetailsRepository;
import com.kanku.repository.ICustomerRepository;
import com.kanku.repository.IProductRepository;
import com.kanku.service.ICustomerOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerOrderDetailsImpl implements ICustomerOrderDetailsService {

    private List<CustomerOrderDetailsDto> customerOrderDetails=new ArrayList<>();

    @Autowired
    private ICustomerOrderDetailsRepository customerOrderDetailsRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<CustomerOrderDetailsDto> getAllCustomerOrderDetails() {


        customerOrderDetailsRepository.findAll().forEach(order -> {

            CustomerOrderDetailsDto customerOrderDetailsDto=new CustomerOrderDetailsDto();
            customerOrderDetailsDto.setOrderNumber(order.getOrderId());
            customerOrderDetailsDto.setOrderDate(order.getOrderDate().toString());
            customerOrderDetailsDto.setOrderQuantity(order.getOrderQuantity());

            Customer customer =customerRepository.findById(order.getCustomer().getCustomerId()).get();
            customerOrderDetailsDto.setCustomerFullName(customer.getFullName());
            customerOrderDetailsDto.setCustomerContactNumber(customer.getContact());
            customerOrderDetailsDto.setCustomerAddress(customer.getAddress());
            customerOrderDetailsDto.setDeliveryStatus(order.getDeliveryStatus());

            Product product =productRepository.findById(order.getProduct().getProductId()).get();
            customerOrderDetailsDto.setProductCategory(product.getProductCategory());
            customerOrderDetailsDto.setProductName(product.getProductName());
            customerOrderDetailsDto.setProductDescription(product.getProductDescription());

            Size size =order.getSize();
            customerOrderDetailsDto.setProductUnitPrice(size.getProductPrice());
            customerOrderDetailsDto.setProductImage(product.getProductImage());
            customerOrderDetailsDto.setTotalPrice(order.getOrderQuantity()*size.getProductPrice());
            customerOrderDetails.add(customerOrderDetailsDto);

        });
        return customerOrderDetails;
    }
}
