package com.kanku.service.impl;

import com.kanku.service.IPendingOrders;

import com.kanku.model.Customer;
import com.kanku.model.Product;
import com.kanku.model.dto.PendingOrderDetailsDto;
import com.kanku.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PendingOrdersImpl implements IPendingOrders {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public List<PendingOrderDetailsDto> getAllPendingOrders() {

        List<PendingOrderDetailsDto> pendingOrders=new ArrayList<>();

        orderRepository.getAllPendingOrders().forEach(order -> {
            PendingOrderDetailsDto pendingOrderDetailsDto=new PendingOrderDetailsDto();

            pendingOrderDetailsDto.setOrderNumber(order.getOrderId());
            pendingOrderDetailsDto.setOrderQuantity(order.getOrderQuantity());
            pendingOrderDetailsDto.setOrderDate(order.getOrderDate().toString());

            Product product =order.getProduct();
            pendingOrderDetailsDto.setProductCategory(product.getProductCategory());
            pendingOrderDetailsDto.setProductName(product.getProductName());
            pendingOrderDetailsDto.setProductImage(product.getProductImage());
            pendingOrderDetailsDto.setProductDescription(product.getProductDescription());
            pendingOrderDetailsDto.setProductUnitPrice(order.getSize().getProductPrice());

            Customer customer =order.getCustomer();
            pendingOrderDetailsDto.setCustomerFullName(customer.getFullName());
            pendingOrderDetailsDto.setCustomerAddress(customer.getAddress());
            pendingOrderDetailsDto.setCustomerContactNumber(customer.getContact());

            pendingOrderDetailsDto.setTotalPrice(order.getOrderQuantity()*order.getSize().getProductPrice());

            pendingOrderDetailsDto.setDeliveryStatus(order.getDeliveryStatus());
            pendingOrders.add(pendingOrderDetailsDto);

        });
        return pendingOrders;
    }
}