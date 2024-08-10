package com.kanku.model.dto;

import com.kanku.model.Customer;
import com.kanku.model.dto.helper.ProductOrders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrderDto {

    private List<ProductOrders> productOrders;

    private Customer customer;
}
