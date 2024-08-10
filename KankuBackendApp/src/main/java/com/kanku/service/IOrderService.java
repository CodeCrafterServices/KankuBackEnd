package com.kanku.service;

import com.kanku.model.ProductOrder;
import com.kanku.model.dto.ProductOrderDto;

public interface IOrderService {
    ProductOrderDto orderProduct(ProductOrderDto productOrderDto) ;

    ProductOrder confirmDelivery(Long orderId);

}
