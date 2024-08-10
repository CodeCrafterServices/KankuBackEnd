package com.kanku.service.impl;

import com.kanku.model.ProductOrder;
import com.kanku.model.Size;
import com.kanku.model.dto.ProductOrderDto;
import com.kanku.repository.IOrderRepository;
import com.kanku.repository.ISizeRepository;
import com.kanku.service.ICartService;
import com.kanku.service.IOrderService;
import com.kanku.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

//    @Autowired
//    private IStockRepository stockRepository;

    @Autowired
    private ISizeRepository sizeRepository;


    @Autowired
    private ISizeService sizeService;

    @Autowired
    private ICartService cartService;

    @Override
    public ProductOrderDto orderProduct(ProductOrderDto productOrderDto) {

        productOrderDto.getProductOrders().forEach(productOrder -> {

            Size size =sizeRepository.findById(productOrder.getSize().getSizeId()).get();

            if(productOrder.getOrderQuantity()>size.getTotalProductQuantity()){
                return;
            }
            ProductOrder po=new ProductOrder();

            po.setCustomer(productOrderDto.getCustomer());
            po.setOrderDate(LocalDate.now());

            po.setProduct(productOrder.getProduct());
            po.setOrderQuantity(productOrder.getOrderQuantity());
            po.setSize(productOrder.getSize());
            po.setDeliveryStatus(false);

            sizeService.updateProductDetails(po);
            orderRepository.save(po);

        });

        cartService.deleteCartsByCustomer(productOrderDto.getCustomer().getCustomerId());
        return productOrderDto;
    }

    @Override
    public ProductOrder confirmDelivery(Long orderId) {

        ProductOrder order = orderRepository.findById(orderId).get();

        order.setDeliveryStatus(true);
        return orderRepository.save(order);
    }
}
