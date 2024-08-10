package com.kanku.model.dto.helper;

import com.kanku.model.Product;
import com.kanku.model.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrders {

    private Product product;

    private Integer orderQuantity;

    private Size size;
}
