package com.kanku.service.impl;

import com.kanku.model.Customer;
import com.kanku.model.Product;
import com.kanku.model.dto.CompletedOrderDetailsDto;
import com.kanku.repository.IOrderRepository;
import com.kanku.service.ICompletedOrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompletedOrdersService implements ICompletedOrderDetails {

    @Autowired
    private IOrderRepository orderRepository;
    @Override
    public List<CompletedOrderDetailsDto> getAllCompletedOrders() {

        List<CompletedOrderDetailsDto> completedOrders=new ArrayList<>();

        orderRepository.getAllCompletedOrders().forEach(order -> {
            CompletedOrderDetailsDto completedOrderDetailsDto=new CompletedOrderDetailsDto();

            completedOrderDetailsDto.setOrderNumber(order.getOrderId());
            completedOrderDetailsDto.setOrderQuantity(order.getOrderQuantity());
            completedOrderDetailsDto.setOrderDate(order.getOrderDate().toString());

            Product product =order.getProduct();
            completedOrderDetailsDto.setProductCategory(product.getProductCategory());
            completedOrderDetailsDto.setProductName(product.getProductName());
            completedOrderDetailsDto.setProductImage(product.getProductImage());
            completedOrderDetailsDto.setProductDescription(product.getProductDescription());
            completedOrderDetailsDto.setProductUnitPrice(order.getSize().getProductPrice());

            Customer customer =order.getCustomer();
            completedOrderDetailsDto.setCustomerFullName(customer.getFullName());
            completedOrderDetailsDto.setCustomerAddress(customer.getAddress());
            completedOrderDetailsDto.setCustomerContactNumber(customer.getContact());

            completedOrderDetailsDto.setTotalPrice(order.getOrderQuantity()*order.getSize().getProductPrice());

            completedOrderDetailsDto.setDeliveryStatus(order.getDeliveryStatus());
            completedOrders.add(completedOrderDetailsDto);
        });

        return completedOrders;
    }
}